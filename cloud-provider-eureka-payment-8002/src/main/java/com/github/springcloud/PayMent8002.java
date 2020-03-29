package com.github.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * author: ouyang
 * Date:2020/3/28 16:06
 **/
@SpringBootApplication
@EnableEurekaClient
public class PayMent8002 {

    public static void main(String[] args) {
        SpringApplication.run(PayMent8002.class);
    }
}
