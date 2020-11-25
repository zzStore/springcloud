package com.symphony.springcloud.alibaba.controller;

import com.symphony.springcloud.entities.CommonResult;
import com.symphony.springcloud.entities.Payment;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhengzhong
 * @Date 2020/11/21 11:15 AM
 */
@RestController
public class PaymentController {

  @Value("${server.port}")
  private String serverPort;

  public static HashMap<Integer,Payment> hashMap = new HashMap<>();

  static {
    hashMap.put(1,new Payment(1,"Payment instance 1"));
    hashMap.put(1,new Payment(2,"Payment instance 2"));
    hashMap.put(1,new Payment(3,"Payment instance 3"));
  }

  @RequestMapping(value = "/paymentSQL/{id}")
  public CommonResult<Payment> paymentSql(@PathVariable("id") Integer id){
    Payment payment = hashMap.get(id);
    CommonResult<Payment> result = new CommonResult<>(200,"from mysql,serverPort:" + serverPort,payment);
    return result;
  }
}
