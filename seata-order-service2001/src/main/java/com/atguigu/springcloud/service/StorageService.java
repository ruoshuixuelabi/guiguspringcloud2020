package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author admin
 */
@FeignClient(value = "seata-storage-service",url ="http://localhost:2002" )
public interface StorageService {
    @RequestMapping("/storage/decrease")
    String decrease(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count);
}
