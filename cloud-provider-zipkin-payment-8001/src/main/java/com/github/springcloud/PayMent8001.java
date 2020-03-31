package com.github.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * author: ouyang
 * Date:2020/3/28 16:06
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PayMent8001 {

    public static void main(String[] args) {
        SpringApplication.run(PayMent8001.class);
    }
}
