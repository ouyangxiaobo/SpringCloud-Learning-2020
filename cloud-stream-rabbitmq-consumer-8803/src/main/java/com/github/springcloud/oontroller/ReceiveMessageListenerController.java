package com.github.springcloud.oontroller;

/**
 * author: ouyang
 * Date:2020/3/31 12:06
 **/
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){

        log.info("我是消费者2号，-----》接受到的消息是："+message.getPayload()+"\t"+serverPort);


    }

}


