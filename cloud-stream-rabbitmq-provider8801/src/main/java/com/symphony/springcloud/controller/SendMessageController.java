package com.symphony.springcloud.controller;

import com.symphony.springcloud.service.IMessageProvider;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.SunHints.Value;

/**
 * @Author zhengzhong
 * @Date 2020/8/26 2:13 PM
 */
@RestController
public class SendMessageController {

  @Resource
  private IMessageProvider messageProvider;

  @GetMapping(value = "/sendMessage")
  public String sendMessage() {
    return messageProvider.send();
  }
}
