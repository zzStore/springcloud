package com.symphoy.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhengzhong
 * @Date 2020/11/7 11:57 AM
 */
@RestController
@Slf4j
public class FlowLimitController {

  @GetMapping("/testA")
  public String testA(){
    log.info(Thread.currentThread().getName() + "\t" + "testA");
    return "----testA";
  }

  @GetMapping("/testB")
  public String testB(){
    return "----testB";
  }

  @GetMapping("/testC")
  public String testC(){
    try {
      Thread.sleep(1000);
      log.info("testC 测试RT");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "----testC";
  }

  @GetMapping("/testD")
  public String testD(){
    log.info("testD 测试异常数和异常比例");
    int age = 10 / 0;
    return "----testD";
  }

  @GetMapping("/testHotKey")
  @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
  public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
      @RequestParam(value = "p2",required = false)String p2){
    return "----testHotKey";
  }

  public String deal_testHotKey(String p1,String p2,BlockException blockException){
    return "---deal_testHotKey o(╥﹏╥)o";
  }
}
