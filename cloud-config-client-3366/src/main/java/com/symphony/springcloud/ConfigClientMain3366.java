package com.symphony.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zhengzhong
 * @Date 2020/8/25 2:53 PM
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3366 {

  public static void main(String[] args) {
    SpringApplication.run(ConfigClientMain3366.class,args);
  }
}