package com.symphony.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.symphony.springcloud.alibaba.service.PaymentService;
import com.symphony.springcloud.entities.CommonResult;
import com.symphony.springcloud.entities.Payment;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zhengzhong
 * @Date 2020/11/21 12:01 PM
 */
@RestController
@Slf4j
public class CircleBreakController {

  public static final String SERVICE_URL = "http://nacos-payment-provider";

  @Resource
  private RestTemplate restTemplate;

  @RequestMapping("/consumer/fallback/{id}")
//  @SentinelResource(value = "fallback")
//  @SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
//  @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责Sentinel控制台配置违规
//  @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
  @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",exceptionsToIgnore = {IllegalArgumentException.class})
  public CommonResult<Payment> fallback(@PathVariable("id") Integer id){
    CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id,CommonResult.class,id);
    if(id == 4){
      throw new IllegalArgumentException("非法参数");
    }else if(result.getData() == null){
      throw new NullPointerException("空指针");
    }
    return result;
  }

  //Fallback兜底方法
  public CommonResult handlerFallback(@PathVariable Integer id,Throwable e){
    Payment payment = new Payment(id,null);
    return new CommonResult(444,"兜底方法handlerFallback，exception内容：" + e.getMessage(),payment);
  }

  //BlockHandler降级方法
  public CommonResult blockHandler(@PathVariable Integer id,BlockException blockException){
    Payment payment = new Payment(id,null);
    return new CommonResult(445,"blockHandler-sentinel限流，无此流水：blockException" + blockException.getMessage());
  }

  @Resource
  private PaymentService paymentService;

  @GetMapping(value = "/consumer/paymentSQL/{id}")
  public CommonResult<Payment> paymentSql(@PathVariable("id") Integer id){
    return paymentService.paymentSql(id);
  }
}
