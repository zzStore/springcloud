package com.symphony.springcloud.alibaba.controller;

import com.symphony.springcloud.alibaba.service.StorageService;
import com.symphony.springcloud.entities.CommonResult;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhengzhong
 * @Date 2020/11/30 5:09 PM
 */
@RestController
public class StorageController {

  @Resource
  private StorageService storageService;

  /**
   * 扣减库存
   */
  @RequestMapping("/storage/decrease")
  public CommonResult decrease(Integer productId,Integer count){
    storageService.decrease(productId, count);
    return new CommonResult(200,"扣减库存成功");
  }
}
