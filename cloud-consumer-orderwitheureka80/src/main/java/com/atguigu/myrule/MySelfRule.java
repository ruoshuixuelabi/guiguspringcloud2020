package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 修改默认的负载均衡的策略
 * 默认是轮询算法，这里改为随机
 *
 * @author admin
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
