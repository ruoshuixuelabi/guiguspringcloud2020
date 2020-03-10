package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author admin
 */
@SpringBootApplication
@MapperScan("com.atguigu.springcloud.mapper")
public class CloudProviderPaymentWithEureka8002Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPaymentWithEureka8002Application.class, args);
    }
}