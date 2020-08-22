package com.symphony.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zhengzhong
 * @Date 2020/8/22 4:55 PM
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3355 {

  public static void main(String[] args) {
    SpringApplication.run(ConfigClientMain3355.class,args);
  }
}