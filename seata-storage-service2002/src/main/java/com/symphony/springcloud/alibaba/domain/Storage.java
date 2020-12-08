package com.symphony.springcloud.alibaba.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhengzhong
 * @Date 2020/11/30 5:21 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

  /**
   * 主键id
   */
  private Integer id;

  /**
   * 产品id
   */
  private Integer productId;

  /**
   * 总库存
   */
  private Integer total;

  /**
   * 已用库存
   */
  private Integer used;

  /**
   * 剩余库存
   */
  private Integer residue;
}
