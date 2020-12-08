package com.symphony.springcloud.alibaba.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhengzhong
 * @Date 2020/11/26 10:32 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  private Integer id;
  private Integer userId;
  private Integer productId;
  private Integer count;
  private BigDecimal money;
  private Integer status; //订单状态：0：创建中，1：已办结

}
