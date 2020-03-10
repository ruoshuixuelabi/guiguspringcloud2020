package com.atguigu.sprigncloud.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author admin
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "ok" + "传入id=" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String paymentInfo_Timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "timeout" + "传入id=" + id;
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_TimeoutHandler" + "传入id=" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreak_fallback", commandProperties = {
            //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreak(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能为负数;");
        }
        String num = UUID.randomUUID().toString();
        return "线程池" + Thread.currentThread().getName() + "调用成功，流水号" + num;
    }
    public String paymentCircuitBreak_fallback(Integer id) {
        return "id不能为负数，请稍后再试id=" + id;
    }
}
