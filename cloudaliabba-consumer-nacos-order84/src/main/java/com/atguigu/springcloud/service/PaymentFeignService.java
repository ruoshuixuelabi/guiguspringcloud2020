package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.impl.PaymentFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author admin
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFeignServiceImpl.class)
public interface PaymentFeignService {
    @GetMapping("paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Integer id);
}
