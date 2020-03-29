package com.github.springcloud.service;

import com.github.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {



    int create(Payment payment);


    Payment getPaymentById(Long id);


}
