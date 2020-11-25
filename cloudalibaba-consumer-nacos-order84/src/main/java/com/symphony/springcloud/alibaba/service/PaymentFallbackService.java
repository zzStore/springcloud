package com.symphony.springcloud.alibaba.service;

import com.symphony.springcloud.entities.CommonResult;
import com.symphony.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author zhengzhong
 * @Date 2020/11/24 10:26 AM
 */
@Component
public class PaymentFallbackService implements PaymentService {

  @Override
  public CommonResult<Payment> paymentSql(Integer id) {
    return new CommonResult<Payment>(444,"服务降级返回",new Payment(id,"error"));
  }
}
