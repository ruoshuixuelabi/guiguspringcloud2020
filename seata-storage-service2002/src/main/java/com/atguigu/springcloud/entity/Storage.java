package com.atguigu.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author K神带你飞
 * @since 2020-03-10
 */
@Data
@Accessors(chain = true)
@TableName("t_storage")
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer productId;
    private Integer total;
    private Integer used;
    private Integer residud;


}
