package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    private static Map<Integer, Payment> map = new HashMap<>();

    static {
        map.put(1, new Payment(1, "111"));
        map.put(2, new Payment(2, "222"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult getPayment(@PathVariable("id") Integer id) {
        Payment payment = map.get(id);
        CommonResult CommonResult = new CommonResult(200, "查询的数据来自服务" + serverPort, payment);
        return CommonResult;
    }
}
