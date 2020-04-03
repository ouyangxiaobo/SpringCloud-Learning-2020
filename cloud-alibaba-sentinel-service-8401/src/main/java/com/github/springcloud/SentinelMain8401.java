package com.github.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * author: ouyang
 * Date:2020/4/3 13:24
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelMain8401
{
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain8401.class, args);
    }
}
