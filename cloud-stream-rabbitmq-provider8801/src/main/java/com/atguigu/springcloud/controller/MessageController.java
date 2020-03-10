package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 */
@RestController
public class MessageController {
    @Autowired
    IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return iMessageProvider.send();
    }
}
