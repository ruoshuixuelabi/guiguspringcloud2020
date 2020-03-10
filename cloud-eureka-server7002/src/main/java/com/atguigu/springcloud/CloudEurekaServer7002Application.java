package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author admin
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServer7002Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer7002Application.class, args);
    }
}
