package com.symphony.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zhengzhong
 * @Date 2020/9/29 2:01 PM
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9002 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain9002.class,args);
  }
}
