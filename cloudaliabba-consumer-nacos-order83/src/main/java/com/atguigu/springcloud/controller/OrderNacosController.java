package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 */
@RestController
public class OrderNacosController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(serviceUrl + "/payment/nacos/" + id, String.class);
    }
}
