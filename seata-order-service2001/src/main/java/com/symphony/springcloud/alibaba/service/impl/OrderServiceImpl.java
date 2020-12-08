package com.symphony.springcloud.alibaba.service.impl;

import com.symphony.springcloud.alibaba.dao.OrderDao;
import com.symphony.springcloud.alibaba.domain.Order;
import com.symphony.springcloud.alibaba.service.AccountService;
import com.symphony.springcloud.alibaba.service.OrderService;
import com.symphony.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author zhengzhong
 * @Date 2020/11/26 4:31 PM
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

  @Resource
  private OrderDao orderDao;

  @Resource
  private AccountService accountService;

  @Resource
  private StorageService storageService;

  @Override
  @GlobalTransactional(name = "zz-create-order",rollbackFor = Exception.class)
  public void create(Order order) {
    log.info("---->开始新建订单");
    //1、新建订单
    orderDao.create(order);

    log.info("----->订单微服务开始调用库存，做扣减");
    //2、扣减库存
    storageService.decrease(order.getProductId(),order.getCount());
    log.info("----->订单微服务扣减完成");

    log.info("---->订单服务开始调用账户，做扣减money");
    //3、扣减账户
    accountService.decrease(order.getUserId(),order.getMoney());
    log.info("---->订单服务调用账户服务扣减money完成");

    log.info("----->修改订单状态开始");
    //4、修改订单状态，从0->1，1代表已经完成
    orderDao.update(order.getUserId(),0);
    log.info("----->修改订单状态完成");

    log.info("下单步骤顺利完成，O(∩_∩)O~");
  }
}
