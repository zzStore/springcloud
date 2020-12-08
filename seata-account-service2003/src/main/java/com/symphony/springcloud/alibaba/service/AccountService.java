package com.symphony.springcloud.alibaba.service;

import java.math.BigDecimal;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zhengzhong
 * @Date 2020/11/30 5:35 PM
 */
public interface AccountService {

  /**
   * 扣减账户余额
   * @param userId 用户id
   * @param money 金额
   */
  void decrease(@Param("userId") Integer userId,@Param("money") BigDecimal money);
}
