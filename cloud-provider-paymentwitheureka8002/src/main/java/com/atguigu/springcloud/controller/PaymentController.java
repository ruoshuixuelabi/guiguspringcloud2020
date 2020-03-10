package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author admin
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Value("${server.port}")
    private  String serverPort;
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        boolean save = paymentService.save(payment);
        log.info("插入结果serverPort="+serverPort + save);
        if (payment != null) {
            return new CommonResult(200, "插入成功serverPort="+serverPort);
        } else {
            return new CommonResult(444, "插入失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id) {
        Payment payment = paymentService.getById(id);
        log.info("查询结果为：{}", payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功serverPort="+serverPort, payment);
        } else {
            return new CommonResult(444, "查询为空");
        }
    }
    @GetMapping("/lb")
    public String getPaymentLb() {
        return serverPort;
    }
    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}

