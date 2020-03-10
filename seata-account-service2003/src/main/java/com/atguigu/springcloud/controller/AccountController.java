package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author K神带你飞
 * @since 2020-03-10
 */
@RestController
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;
    @GetMapping("/account/decrease")
    public String create (Integer userId, BigDecimal money) {
        accountService.descrease(userId,money);
        System.out.println("我是钓鱼共成功的");
        return "account减库存陈宫成功";
    }
}

