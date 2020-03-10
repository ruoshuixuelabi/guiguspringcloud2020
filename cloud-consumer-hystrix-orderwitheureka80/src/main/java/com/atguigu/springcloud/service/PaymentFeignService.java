package com.atguigu.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author admin
 */
@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = PaymentFallbackService.class)
public interface PaymentFeignService {
    @GetMapping("/payment/hystrix/ok/{id}")
    String getPaymentById(@PathVariable("id") Integer id);
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentFeignTimeout(@PathVariable("id") Integer id);


}