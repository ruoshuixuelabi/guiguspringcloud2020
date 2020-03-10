package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 */
@SpringBootApplication
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class CloudConsumerOrderWithEureka80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderWithEureka80Application.class, args);
    }
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
