package com.symphony.springcloud.alibaba.service.impl;

import com.alibaba.csp.sentinel.util.TimeUtil;
import com.symphony.springcloud.alibaba.dao.AccountDao;
import com.symphony.springcloud.alibaba.service.AccountService;
import java.math.BigDecimal;
import javax.annotation.Resource;
import org.apache.tomcat.jni.Time;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author zhengzhong
 * @Date 2020/11/30 5:36 PM
 */
@Service
public class AccountServiceImpl implements AccountService {


  private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

  @Resource
  private AccountDao accountDao;

  /**
   * 扣减账户余额
   * @param userId 用户id
   * @param money 金额
   */
  @Override
  public void decrease(Integer userId, BigDecimal money) {
    LOGGER.info("---->account-service中扣减账户余额开始");
//    try {
//      Thread.sleep(2000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    accountDao.decrease(userId, money);
    LOGGER.info("---->account-service中扣减账户余额结束");
  }
}
