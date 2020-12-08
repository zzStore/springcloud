package com.symphony.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhengzhong
 * @Date 2020/11/26 10:29 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

  private Integer code;
  private String message;
  private T data;
  public CommonResult(Integer code,String message){
    this(code,message,null);
  }
}
