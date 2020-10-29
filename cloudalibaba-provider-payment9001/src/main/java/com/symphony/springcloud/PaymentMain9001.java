package com.symphony.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zhengzhong
 * @Date 2020/9/29 2:00 PM
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9001 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain9001.class,args);
  }
}
