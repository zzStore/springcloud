package com.symphony.springcloud.alibaba.service.impl;

import com.symphony.springcloud.alibaba.dao.StorageDao;
import com.symphony.springcloud.alibaba.service.StorageService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author zhengzhong
 * @Date 2020/11/30 5:04 PM
 */
@Service
public class StorageServiceImpl implements StorageService {

  private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

  @Resource
  private StorageDao storageDao;

  @Override
  public void decrease(Integer productId, Integer count) {
    LOGGER.info("---->storage-service中扣减库存开始");
    storageDao.decrease(productId, count);
    LOGGER.info("---->storage-service中扣减库存结束");
  }
}
