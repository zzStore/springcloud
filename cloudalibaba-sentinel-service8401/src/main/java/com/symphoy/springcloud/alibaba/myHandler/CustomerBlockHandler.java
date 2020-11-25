package com.symphoy.springcloud.alibaba.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.symphony.springcloud.entities.CommonResult;

/**
 * @Author zhengzhong
 * @Date 2020/11/20 4:07 PM
 */
public class CustomerBlockHandler {

  public static CommonResult handlerException(BlockException exception){
    return new CommonResult(333,"自定义，global handlerException");
  }

  public static CommonResult handlerException2(BlockException exception){
    return new CommonResult(555,"自定义，global handlerException2");
  }
}
