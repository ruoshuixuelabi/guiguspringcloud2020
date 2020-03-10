package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.myhandler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author admin
 */
@RestController
@Slf4j
public class RateLimitController {


    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerException")
    public CommonResult testHotKey() {
        return new CommonResult(200, "按照资源名称限流pk", new Payment(2020, "serial2020"));
    }

    public CommonResult handlerException(BlockException e) {
        return new CommonResult(4444, e.getClass().getCanonicalName() + "服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按byUrl限流pk", new Payment(2020, "serial2020"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客户自定义限流pk", new Payment(2020, "serial2020"));
    }
}
