package com.atguigu.springcloud.myhandler;

import com.atguigu.springcloud.entity.CommonResult;

public class CustomerBlockHandler {
    public  static CommonResult handlerException(){
        return new CommonResult(444, "按客户自定义限流pk,全局的=--------1");
    }
    public  static CommonResult handlerException2(){
        return new CommonResult(444, "按客户自定义限流pk,全局的=--------2");
    }
}
