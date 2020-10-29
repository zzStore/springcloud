package com.symphony.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhengzhong
 * @Date 2020/10/12 4:59 PM
 */
@RestController
@RefreshScope //支持Nacos的动态刷新功能
public class ConfigClientController {

  @Value("${config.info}")
  private String configInfo;

  @GetMapping("/config/info")
  public String getConfigInfo(){
    return configInfo;
  }
}
