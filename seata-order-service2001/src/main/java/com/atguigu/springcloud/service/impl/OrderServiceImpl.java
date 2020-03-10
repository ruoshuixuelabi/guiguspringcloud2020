package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Order;
import com.atguigu.springcloud.mapper.OrderMapper;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author K神带你飞
 * @since 2020-03-10
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private AccountService accountService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private StorageService storageService;

    @GlobalTransactional(name = "ruoshui_create_group",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("开始创建订单");
        orderService.save(order);
        log.info("订单微服务开始调用库存微服务");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("订单微服务开始调用库存微服务,结束");
        log.info("订单微服务开始调用账户微服务");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("订单微服务开始调用账户微服务,结束");
        log.info("修改订单状态开始");
        order.setStatus(1);
        orderService.updateById(order);
        log.info("修改订单状态结束");
    }
}
