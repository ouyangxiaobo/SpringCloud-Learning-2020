package com.github.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * author: ouyang
 * Date:2020/3/28 17:01
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsul80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsul80.class);
    }
}
