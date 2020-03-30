package com.github.springcloud.controller;

import com.github.springcloud.common.CommonResult;
import com.github.springcloud.entities.Payment;
import com.github.springcloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author: ouyang
 * Date:2020/3/30 11:31
 **/
@RestController
@Slf4j
public class OrderFeignController {


    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return orderFeignService.getPaymentById(id);
    }
}
