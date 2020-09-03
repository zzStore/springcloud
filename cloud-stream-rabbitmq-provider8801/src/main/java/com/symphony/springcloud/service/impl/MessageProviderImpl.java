package com.symphony.springcloud.service.impl;

import com.symphony.springcloud.service.IMessageProvider;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @Author zhengzhong
 * @Date 2020/8/26 2:07 PM
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

  @Resource
  private MessageChannel output; //消息发送管道

  @Override
  public String send() {
    String serial = UUID.randomUUID().toString();
    output.send(MessageBuilder.withPayload(serial).build());
    System.out.println("******" + serial);
    return null;
  }
}
