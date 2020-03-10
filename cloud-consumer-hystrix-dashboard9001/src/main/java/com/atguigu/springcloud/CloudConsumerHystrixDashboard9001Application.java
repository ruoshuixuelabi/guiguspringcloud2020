package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class CloudConsumerHystrixDashboard9001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerHystrixDashboard9001Application.class, args);
    }

}
