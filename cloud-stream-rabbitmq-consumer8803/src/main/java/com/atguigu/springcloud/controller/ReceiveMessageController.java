package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageController {
    @Value("${server.port}")
    String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> stringMessage) {
        log.info("接受度奥的消息的" + stringMessage.getPayload()+"；端口="+serverPort);
    }
}
