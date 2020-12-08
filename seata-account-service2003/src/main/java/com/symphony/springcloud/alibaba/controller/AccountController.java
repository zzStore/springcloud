package com.symphony.springcloud.alibaba.controller;

import com.symphony.springcloud.alibaba.service.AccountService;
import com.symphony.springcloud.entities.CommonResult;
import java.math.BigDecimal;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhengzhong
 * @Date 2020/11/30 5:50 PM
 */
@RestController
public class AccountController {

  @Resource
  private AccountService accountService;

  /**
   * 扣减账户余额
   */
  @RequestMapping("/account/decrease")
  public CommonResult decrease(Integer userId,BigDecimal money){
    accountService.decrease(userId,money);
    return new CommonResult(200,"扣减账户余额成功");
  }
}
