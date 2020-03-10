package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENY_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
   private PaymentFeignService paymentFeignService;

//    @PostMapping("/consumer/payment/create")
//    public CommonResult<Payment> create(Payment payment) {
//        return restTemplate.postForObject(PAYMENY_URL + "payment/create", payment, CommonResult.class);
//    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Integer id) {
        log.info("我是使用的Feign");
        return  paymentFeignService.getPaymentById(id);
    }
    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        log.info("我是使用的Feign");
        return  paymentFeignService.paymentFeignTimeout();
    }
}

