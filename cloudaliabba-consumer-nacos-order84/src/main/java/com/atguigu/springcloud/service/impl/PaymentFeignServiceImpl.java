package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Component;

/**
 * @author admin
 */
@Component
public class PaymentFeignServiceImpl implements PaymentFeignService {
    @Override
    public CommonResult<Payment> paymentSQL(Integer id) {
        return new CommonResult(444, "服务降级返回", new Payment(id, "error"));
    }
}
