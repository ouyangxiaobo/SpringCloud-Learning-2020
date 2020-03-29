package com.github.springcloud.controller;

import com.github.springcloud.common.CommonResult;
import com.github.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
 * author: ouyang
 * Date:2020/3/28 17:09
 **/
@RestController
@Slf4j
public class OrderController {

    //public static  final String PAY_URL="http://localhost:8001";

    //通过服务名进行负载均衡访问
    public static  final String PAY_URL="http://cloud-provider-payment";



    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/zk")
    public String paymentZK(){
        return restTemplate.getForObject(PAY_URL+"/payment/zk",String.class);
    }

    @GetMapping("/consumer/create")
    public CommonResult<Payment> createPayment(Payment payment){

        return restTemplate.postForObject(PAY_URL+"/payment/create", payment,CommonResult.class );

    }

    @GetMapping("/consumer/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        log.info("id="+id);

        return restTemplate.getForObject(PAY_URL+"/payment/getPaymentById/"+id,CommonResult.class );

    }
}
