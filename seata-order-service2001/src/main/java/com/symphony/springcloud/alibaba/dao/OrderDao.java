package com.symphony.springcloud.alibaba.dao;

import com.symphony.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zhengzhong
 * @Date 2020/11/26 10:36 AM
 */
@Mapper
public interface OrderDao {

  //1 新建订单
  void create(Order order);

  //2 修改订单状态，从0改成1
  void update(@Param("userId") Integer userId,@Param("status") Integer status);
}
