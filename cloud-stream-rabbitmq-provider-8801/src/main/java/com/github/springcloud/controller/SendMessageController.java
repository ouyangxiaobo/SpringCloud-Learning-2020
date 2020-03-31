package com.github.springcloud.controller;

import com.github.springcloud.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author: ouyang
 * Date:2020/3/31 11:54
 **/
@RestController
@Slf4j
public class SendMessageController {


    @Resource
    private IMessageService messageService;

    @RequestMapping("/sendMessage")
    public String sendMessage() {
        String send = messageService.send();
        return send;
    }

}



