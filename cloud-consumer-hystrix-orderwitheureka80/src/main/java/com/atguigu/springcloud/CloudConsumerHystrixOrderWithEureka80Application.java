package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author admin
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class CloudConsumerHystrixOrderWithEureka80Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerHystrixOrderWithEureka80Application.class, args);
    }
}