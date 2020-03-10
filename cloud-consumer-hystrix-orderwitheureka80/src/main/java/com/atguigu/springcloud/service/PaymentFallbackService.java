package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author admin
 */
@Component
public class PaymentFallbackService implements  PaymentFeignService {
    @Override
    public String getPaymentById(Integer id) {
        return "PaymentFallbackService ok";
    }

    @Override
    public String paymentFeignTimeout(Integer id) {
        return "PaymentFallbackService timeout";
    }
}
