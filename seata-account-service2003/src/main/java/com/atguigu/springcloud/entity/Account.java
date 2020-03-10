package com.atguigu.springcloud.entity;

import java.io.Serializable;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("t_account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
