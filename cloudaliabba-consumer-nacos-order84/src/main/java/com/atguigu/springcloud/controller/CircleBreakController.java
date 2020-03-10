package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 */
@RestController
public class CircleBreakController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PaymentFeignService paymentFeignService;
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping(value = "/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")//fallback只负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")//blockHandler只负责sentinel控制台违规
//    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")//blockHandler只负责sentinel控制台违规
    @SentinelResource(value = "fallback", fallback = "handlerFallback",
            exceptionsToIgnore = {IllegalArgumentException.class},
            blockHandler = "blockHandler")
    public CommonResult<Payment> getPayment(@PathVariable("id") Integer id) {
        CommonResult<Payment> result = restTemplate.getForObject(serviceUrl + "/paymentSQL/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("参数非法");
        } else if (result.getDada() == null) {
            throw new NullPointerException("空指针");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable("id") Integer id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(444, "兜底的异常处理" + e.getMessage(), payment);
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id") Integer id, BlockException e) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(445, "blockHandler异常处理" + e.getMessage(), payment);
    }

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentSQL(id);
    }
}
