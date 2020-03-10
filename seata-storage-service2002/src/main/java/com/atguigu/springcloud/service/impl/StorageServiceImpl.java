package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entity.Storage;
import com.atguigu.springcloud.mapper.StorageMapper;
import com.atguigu.springcloud.service.StorageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {
    @Autowired
    StorageMapper storageMapper;

    public void descrease(Integer productId, Integer count) {
        log.info("StorageServiceImpl开始扣减库存");
        Storage storage = new Storage();
        storage.setProductId(productId);
        storageMapper.update(storage,
                new UpdateWrapper<Storage>().setSql("used=used+" + count + "   , residud=residud-" + count));
        log.info("StorageServiceImpl结束扣减付村");
    }
}
