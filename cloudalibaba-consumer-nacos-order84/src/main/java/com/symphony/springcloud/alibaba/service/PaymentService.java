package com.symphony.springcloud.alibaba.service;

import com.symphony.springcloud.entities.CommonResult;
import com.symphony.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zhengzhong
 * @Date 2020/11/24 10:23 AM
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

  @GetMapping(value = "/paymentSQL/{id}")
  public CommonResult<Payment> paymentSql(@PathVariable("id") Integer id);
}
