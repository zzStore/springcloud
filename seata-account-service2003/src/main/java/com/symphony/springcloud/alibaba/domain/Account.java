package com.symphony.springcloud.alibaba.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhengzhong
 * @Date 2020/11/30 5:18 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

  /**
   * 主键id
   */
  private Integer id;

  /**
   * 用户id
   */
  private Integer userId;

  /**
   * 总额度
   */
  private BigDecimal total;

  /**
   * 已用额度
   */
  private BigDecimal used;

  /**
   * 剩余额度
   */
  private BigDecimal residue;
}
