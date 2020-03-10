package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author admin
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudaliabbaProviderPayment9001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudaliabbaProviderPayment9001Application.class, args);
    }

}
