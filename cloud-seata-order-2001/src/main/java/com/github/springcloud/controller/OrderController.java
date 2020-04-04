package com.github.springcloud.controller;


import com.github.springcloud.domain.Account;
import com.github.springcloud.domain.CommonResult;
import com.github.springcloud.domain.Order;
import com.github.springcloud.service.AccountService;
import com.github.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
public class OrderController
{
    @Resource
    private OrderService orderService;

    @Resource
    private AccountService accountService;


    @PostMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }


    @GetMapping("/order/getAccountById/{id}")
    public Account getAccountById(@PathVariable("id") Long id)
    {
        log.info("id==="+id);
        Account account = accountService.getAccountById(id);
        log.info("查询结果:"+account.toString());
        return account;

    }

    @GetMapping("/order/getOrderById/{id}")
    public Order getOrderById(@PathVariable("id") Long id)
    {
        log.info("id==="+id);
        Order order = orderService.getOrderById(id);
        log.info("查询结果:"+order.toString());
        return order;

    }
}
