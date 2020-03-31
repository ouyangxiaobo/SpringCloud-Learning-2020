package com.github.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * author: ouyang
 * Date:2020/3/31 12:05
 **/
@SpringBootApplication
@EnableEurekaClient
public class StreamMain8803 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMain8803.class);
    }
}
