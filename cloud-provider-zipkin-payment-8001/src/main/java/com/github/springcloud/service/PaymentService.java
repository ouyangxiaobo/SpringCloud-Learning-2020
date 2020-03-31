package com.github.springcloud.service;

import com.github.springcloud.entities.Payment;

public interface PaymentService {



    int create(Payment payment);


    Payment getPaymentById(Long id);


}
