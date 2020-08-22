package com.symphony.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author zhengzhong
 * @Date 2020/8/21 3:46 PM
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {

  public static void main(String[] args) {
    SpringApplication.run(ConfigCenterMain3344.class,args);
  }
}

