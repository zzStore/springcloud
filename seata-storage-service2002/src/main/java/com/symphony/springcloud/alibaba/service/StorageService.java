package com.symphony.springcloud.alibaba.service;

/**
 * @Author zhengzhong
 * @Date 2020/11/30 5:03 PM
 */
public interface StorageService {

  /**
   * 扣减库存
   */
  void decrease(Integer productId,Integer count);
}
