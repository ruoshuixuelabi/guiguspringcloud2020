package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.service.impl.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author K神带你飞
 * @since 2020-03-10
 */
@RestController
public class StorageController {
    @Autowired
    private StorageServiceImpl storageService;

    @RequestMapping("/storage/decrease")
    public String decrease(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count) {
        storageService.descrease(productId, count);
        System.out.println("我是调用工具成功的storage");
        return "减库存陈宫成功";
    }
}