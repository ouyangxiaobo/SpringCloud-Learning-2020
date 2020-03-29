package com.github.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * author: ouyang
 * Date:2020/3/28 19:01
 **/
@EnableEurekaServer
@SpringBootApplication
public class Eureka7001 {

    public static void main(String[] args) {

        SpringApplication.run(Eureka7001.class);


    }
}
