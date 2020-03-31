package com.github.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * author: ouyang
 * Date:2020/3/28 17:01
 **/
@SpringBootApplication
@EnableEurekaClient
public class OrdeZipkin80 {

    public static void main(String[] args) {
        SpringApplication.run(OrdeZipkin80.class);
    }
}
