package com.github.springcloud.service.impl;

import com.github.springcloud.dao.PaymentDao;
import com.github.springcloud.entities.Payment;
import com.github.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author: ouyang
 * Date:2020/3/28 16:28
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
