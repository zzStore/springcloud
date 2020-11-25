package com.symphoy.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.symphony.springcloud.entities.CommonResult;
import com.symphoy.springcloud.alibaba.myHandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhengzhong
 * @Date 2020/11/20 3:52 PM
 */
@RestController
public class RateLimitController {

  @RequestMapping("/byResource")
  @SentinelResource(value = "byResource",blockHandler = "handleException")
  public CommonResult byResource(){
    return new CommonResult(2020,"按资源名称限流","serial001");
  }

  public CommonResult handleException(BlockException exception){
    return new CommonResult(444,exception.getClass().getCanonicalName() + "\t 服务不可用");
  }

  @RequestMapping("/rateLimit/byUrl")
  @SentinelResource(value = "byUrl")
  public CommonResult byUrl(){
    return new CommonResult(2021,"按Url限流","serial002");
  }

  @RequestMapping("/byMyHandler")
  @SentinelResource(value = "byMyHandler",
      blockHandlerClass = CustomerBlockHandler.class,
      blockHandler = "handlerException2")
  public CommonResult byMyHandler(){
    return new CommonResult(2022,"按自定义方法降级处理","serial003");
  }
}
