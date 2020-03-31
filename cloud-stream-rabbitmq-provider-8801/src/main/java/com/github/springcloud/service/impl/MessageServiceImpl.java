package com.github.springcloud.service.impl;

import cn.hutool.core.lang.UUID;
import com.github.springcloud.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * author: ouyang
 * Date:2020/3/31 11:53
 **/

@EnableBinding(Source.class)  //定义消息推送通道
@Slf4j
public class MessageServiceImpl implements IMessageService {

    @Resource
    private MessageChannel output;  //消息发送通道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString().replaceAll("-","" );
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("发送信息，serial: "+serial);
        return serial;

    }
}
