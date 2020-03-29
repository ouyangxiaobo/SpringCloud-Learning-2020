package com.github.springcloud.dao;

import com.github.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * author: ouyang
 * Date:2020/3/28 16:17
 **/

@Mapper
@Repository
public interface PaymentDao {



    int create(Payment payment);


    Payment getPaymentById(@Param("id") Long id);
}



