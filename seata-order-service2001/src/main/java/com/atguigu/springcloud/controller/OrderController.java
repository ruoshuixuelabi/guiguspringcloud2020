package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Order;
import com.atguigu.springcloud.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 */
@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @RequestMapping("/order/create")
    public CommonResult create(Order order) {
        orderServiceImpl.create(order);
        return new CommonResult(200, "创建顶你买单成功");
    }
}

