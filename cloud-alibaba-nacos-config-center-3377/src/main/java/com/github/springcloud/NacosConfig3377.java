package com.github.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * author: ouyang
 * Date:2020/3/31 19:05
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfig3377 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfig3377.class, args);
    }

}
