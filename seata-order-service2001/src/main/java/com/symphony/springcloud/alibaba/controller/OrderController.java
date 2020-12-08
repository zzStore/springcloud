package com.symphony.springcloud.alibaba.controller;

import com.symphony.springcloud.alibaba.domain.CommonResult;
import com.symphony.springcloud.alibaba.domain.Order;
import com.symphony.springcloud.alibaba.service.OrderService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhengzhong
 * @Date 2020/11/26 4:55 PM
 */
@RestController
public class OrderController {

  @Resource
  private OrderService orderService;

  @GetMapping("/order/create")
  public CommonResult create(Order order){
    orderService.create(order);
    return new CommonResult(200,"订单创建成功");
  }
}
