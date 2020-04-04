package com.github.springcloud.service;


import com.github.springcloud.domain.Order;

public interface OrderService
{
    void create(Order order);

    Order getOrderById(Long id);
}
