package com.github.springcloud.controller;

import com.github.springcloud.common.CommonResult;
import com.github.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author: ouyang
 * Date:2020/3/30 12:50
 **/
@RestController
@Slf4j
public class OrderHystrixController {


    @Resource
    private OrderHystrixService orderHystrixService;

   /*-------------服务降级----------------*/
    /**
     * 正常访问
     * http://localhost/consumer/payment/hystrix/ok/31
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return orderHystrixService.paymentInfo_OK(id);
    }
    /**
     * 超时访问，消费者自身时间小于，提供者的时间，也会出现超时，由于一个接口写一个异常处理方法，导致代码膨胀，业务代码和异常处理在一块，高耦合了，建议全局异常处理
     *
     * @param id
     * @return
     */
   /* @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
   })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        //int age = 10 / 0;  //运行时异常
        return orderHystrixService.paymentInfo_TimeOut(id);
    }

    private String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "消费者80，对方支付系统繁忙，或自己运行出错请检查自己，请10秒后再试。";
    }*/



    /**
     * @ClassName OrderHystrixController
     * @Description : 服务降级，采用全局异常处理
     * @Return :
     * @Author : ouyang
     * @Date : 2020/3/30 14:07
    **/
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    //@HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        //int age = 10 / 0;  //运行时异常
        return orderHystrixService.paymentInfo_TimeOut(id);
    }


    /**
     * 全局fallback方法
     *
     * @return
     */
    private String payment_Global_FallbackMethod() {
        return "Global异常处理信息,请稍后再试。";
    }


}
