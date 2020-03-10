package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_Global_TimeoutHandler")
public class OrderController {
    @Autowired
    private PaymentFeignService paymentFeignService;
    @GetMapping("/consumer/payment/get/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        log.info("我是使用的Feign");
        return  paymentFeignService.getPaymentById(id);
    }
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
     @HystrixCommand
    @GetMapping("/consumer/payment/feign/timeout/{id}")
    public String paymentFeignTimeout(@PathVariable("id") Integer id) {
        log.info("我是使用的Feign");
        return  paymentFeignService.paymentFeignTimeout(id);
    }

    public String paymentInfo_TimeoutHandler( Integer id) {
        return "生产者很忙，因此我找能自己来了"+id;
    }
    public String paymentInfo_Global_TimeoutHandler() {
        return "我是全局的处理";
    }
}