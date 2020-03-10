package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author admin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private  Integer code;
    private  String message;
    private  T dada;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
