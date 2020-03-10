package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author admin
 */
@FeignClient("seata-account-service")
public interface AccountService {
    @RequestMapping("/account/decrease")
    String decrease(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money);
}
