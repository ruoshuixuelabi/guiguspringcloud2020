package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author admin
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigClient3344Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient3344Application.class, args);
    }
}
