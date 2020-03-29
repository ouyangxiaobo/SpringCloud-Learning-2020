package com.github.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * author: ouyang
 * Date:2020/3/28 16:06
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PayMent8006 {

    public static void main(String[] args) {
        SpringApplication.run(PayMent8006.class);
    }
}
