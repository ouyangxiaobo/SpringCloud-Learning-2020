package com.github.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
public class FlowLimitController {



    /*测试sentinel服务流控---QPS/线程，单机阈值，流控模式--直接，关联，链路，流控效果--快速失败，warm up(冷启动)，排队等待*/
    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "------testB";
    }


    /*测试 sentinel服务降级--*/
    /*RT*/

    @GetMapping("/testC")
    public String testC()
    {
      try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
      log.info("testC 测试RT");

        return "------testC";
    }

    /*测试 sentinel服务降级--*/
    /*异常比例*/

    @GetMapping("/testD")
    public String testD()
    {
        log.info("testD 异常比例");
        int age = 10/0;
        return "------testD";

    }

    /*测试 sentinel服务降级--*/
    /*异常数*/
    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }










}
