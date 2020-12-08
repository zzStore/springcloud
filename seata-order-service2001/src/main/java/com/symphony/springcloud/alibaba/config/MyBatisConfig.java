package com.symphony.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhengzhong
 * @Date 2020/11/26 4:58 PM
 */
@Configuration
@MapperScan({"com.symphony.springcloud.alibaba.dao"})
public class MyBatisConfig {

}
