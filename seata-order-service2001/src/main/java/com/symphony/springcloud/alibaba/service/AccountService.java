package com.symphony.springcloud.alibaba.service;

import com.symphony.springcloud.alibaba.domain.CommonResult;
import java.math.BigDecimal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author zhengzhong
 * @Date 2020/11/26 4:32 PM
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

  @PostMapping(value = "/account/decrease")
  CommonResult decrease(@RequestParam("userId") Integer userId,@RequestParam("money") BigDecimal money);
}
