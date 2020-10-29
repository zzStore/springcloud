package com.symphony.springcloud.alibaba.controller;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zhengzhong
 * @Date 2020/9/29 2:52 PM
 */
@Slf4j
@RestController
public class OrderController {

  @Resource
  private RestTemplate restTemplate;

  @Value("${service-url.nacos-user-service}")
  private String serverURL;

  @GetMapping(value = "/consumer/payment/nacos/{id}")
  public String paymentInfo(@PathVariable("id") Long id){
    return restTemplate.getForObject(serverURL + "/payment/nacos/" + id,String.class);
  }
}
