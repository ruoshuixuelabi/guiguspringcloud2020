package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 */
@SpringBootApplication
public class CloudConsumerOrder80Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80Application.class, args);
    }
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
