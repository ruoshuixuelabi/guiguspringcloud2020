package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.intfo}")
    private String configInfo;
    @GetMapping("configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
