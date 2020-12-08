package com.symphony.springcloud.alibaba.service;

import com.symphony.springcloud.alibaba.domain.Order;

/**
 * @Author zhengzhong
 * @Date 2020/11/26 4:50 PM
 */
public interface OrderService {

  void create(Order order);
}
