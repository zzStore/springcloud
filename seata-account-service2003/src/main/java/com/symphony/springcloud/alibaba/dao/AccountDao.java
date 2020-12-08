package com.symphony.springcloud.alibaba.dao;

import java.math.BigDecimal;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zhengzhong
 * @Date 2020/11/30 5:26 PM
 */
public interface AccountDao {

  /**
   * 扣减账户余额
   * @param userId
   * @param money
   */
  void decrease(@Param("userId") Integer userId,@Param("money") BigDecimal money);
}
