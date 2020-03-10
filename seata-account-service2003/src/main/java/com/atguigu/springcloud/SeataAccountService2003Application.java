package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.atguigu.springcloud.mapper")
@EnableDiscoveryClient
public class SeataAccountService2003Application {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountService2003Application.class, args);
    }
}
