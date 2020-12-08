package com.symphony.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zhengzhong
 * @Date 2020/11/30 4:46 PM
 */
@Mapper
public interface StorageDao {

  //扣减库存
  void decrease(@Param("productId") Integer productId, @Param("count") Integer count);
}
