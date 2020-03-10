package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entity.Account;
import com.atguigu.springcloud.mapper.AccountMapper;
import com.atguigu.springcloud.service.AccountService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author K神带你飞
 * @since 2020-03-10
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Autowired
    private  AccountMapper accountMapper;

    public void descrease(Integer userId, BigDecimal money) {
        log.info("AccountServiceImpl开始执行了");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Account storage=new Account();
        storage.setUserId(userId);
        accountMapper.update(storage,
                new UpdateWrapper<Account>().setSql("residue=residue-"+money+"   , used=used+"+money));
        log.info("AccountServiceImpl结束执行了");
    }
}
