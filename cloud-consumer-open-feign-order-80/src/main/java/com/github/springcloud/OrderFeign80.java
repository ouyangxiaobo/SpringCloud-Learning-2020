package com.github.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * author: ouyang
 * Date:2020/3/30 11:27
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderFeign80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeign80.class);
    }
}
