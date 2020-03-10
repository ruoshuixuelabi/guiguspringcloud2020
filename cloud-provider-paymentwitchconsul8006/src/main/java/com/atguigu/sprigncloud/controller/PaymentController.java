package com.atguigu.sprigncloud.controller;


import com.atguigu.sprigncloud.service.PaymentService;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
    private String serverPort;
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        boolean save = paymentService.save(payment);
        log.info("插入结果"+save);
        if(payment!=null){
            return  new CommonResult(200,"插入成功");
        }else{
            return  new CommonResult(444,"插入失败");
        }
    }
    @GetMapping("/zk")
    public String paynmentzk(){
        return "Srping Cloud witch zookeeper"+serverPort;
    }
    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        Payment payment = paymentService.getById(id);
        log.info("查询结果为：{}",payment);
        if(payment!=null){
            return  new CommonResult(200,"查询成功",payment);
        }else{
            return  new CommonResult(444,"查询为空");
        }
    }
}

