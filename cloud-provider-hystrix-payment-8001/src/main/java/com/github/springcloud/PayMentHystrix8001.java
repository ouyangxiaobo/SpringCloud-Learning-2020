package com.github.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * author: ouyang
 * Date:2020/3/30 12:28
 **/
@SpringBootApplication
@EnableEurekaClient
public class PayMentHystrix8001 {

    public static void main(String[] args) {
        SpringApplication.run(PayMentHystrix8001.class);
    }
}
