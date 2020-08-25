package com.symphony.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhengzhong
 * @Date 2020/8/25 2:54 PM
 */
@RestController
@RefreshScope
public class ConfigClientController {

  @Value("${config.info}")
  private String configInfo;

  @GetMapping("/configInfo")
  public String getConfigInfo(){
    return configInfo;
  }

}

