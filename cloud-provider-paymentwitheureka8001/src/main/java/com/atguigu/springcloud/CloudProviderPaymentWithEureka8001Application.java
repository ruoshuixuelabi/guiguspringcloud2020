package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author admin
 */
@SpringBootApplication
@MapperScan("com.atguigu.springcloud.mapper")
public class CloudProviderPaymentWithEureka8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPaymentWithEureka8001Application.class, args);
    }


}