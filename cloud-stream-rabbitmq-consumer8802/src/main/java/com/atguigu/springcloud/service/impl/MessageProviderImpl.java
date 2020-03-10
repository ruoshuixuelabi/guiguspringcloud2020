package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author admin
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {
    //消息发送管道
    @Autowired
    private MessageChannel output;
    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        System.out.println("订单号s="+s);
        output.send(MessageBuilder.withPayload(s).build());
        return s;
    }
}
