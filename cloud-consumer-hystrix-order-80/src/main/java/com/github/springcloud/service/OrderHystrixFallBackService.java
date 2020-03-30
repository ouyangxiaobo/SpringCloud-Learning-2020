package com.github.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * author: ouyang 服务降级，全局异常处理
 * Date:2020/3/30 14:09
 **/
@Component
public class OrderHystrixFallBackService implements OrderHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back--paymentInfo_OK,服务正常访问";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "        ----PaymentFallbackService fall back--paymentInfo_ERROR,服务请求超时，请稍后再试";
    }
}
