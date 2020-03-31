package com.github.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * author: ouyang
 * Date:2020/3/31 18:46
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class);
    }
}
