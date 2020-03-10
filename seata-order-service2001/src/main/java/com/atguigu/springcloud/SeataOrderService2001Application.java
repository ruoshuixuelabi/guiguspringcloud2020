package com.atguigu.springcloud;

import feign.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author admin
 */
@SpringBootApplication
@MapperScan("com.atguigu.springcloud.mapper")
@EnableFeignClients
public class SeataOrderService2001Application {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderService2001Application.class, args);
    }
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
