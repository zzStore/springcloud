package com.symphony.springcloud.alibaba.service;

import com.symphony.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author zhengzhong
 * @Date 2020/11/26 4:33 PM
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

  @PostMapping(value = "/storage/decrease")
  CommonResult decrease(@RequestParam("productId") Integer productId,@RequestParam("count") Integer count);
}
