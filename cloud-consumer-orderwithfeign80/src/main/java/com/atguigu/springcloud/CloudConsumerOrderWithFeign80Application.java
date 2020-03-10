package com.atguigu.springcloud;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 */
@SpringBootApplication
@EnableFeignClients
public class CloudConsumerOrderWithFeign80Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderWithFeign80Application.class, args);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}