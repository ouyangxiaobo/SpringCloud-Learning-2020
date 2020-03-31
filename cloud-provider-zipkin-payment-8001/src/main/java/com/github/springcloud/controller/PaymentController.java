package com.github.springcloud.controller;

import com.github.springcloud.common.CommonResult;
import com.github.springcloud.entities.Payment;
import com.github.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * author: ouyang
 * Date:2020/3/28 16:30
 **/
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        try {

            log.info("payment:"+payment.toString());

            int result=paymentService.create(payment);
            if(result>0){

                return new CommonResult(200,"添加成功,端口号serverPort："+serverPort,result);
            }else {
                return new CommonResult(500,"添加失败",null);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    @GetMapping("/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        try {

            log.info("id:"+id);

            Payment payment=paymentService.getPaymentById(id);

            if(payment!=null){
                return new CommonResult(200,"查询成功端口号serverPort："+serverPort,payment.toString());
            }else {
                return new CommonResult(404,"查询不到",null);
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    /**
     * @ClassName PaymentController
     * @Description : 获取服务的信息，地址，服务名，url等信息
     * @Return :
     * @Author : ouyang
     * @Date : 2020/3/28 20:55
    **/

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element:" + element);
        }
        // 一个微服务下的全部实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() +"\t"+ instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public  String getServerPort(){
        return serverPort;
    }


    @GetMapping("/feign/timeout")
    public  String  paymenFeigntTimeOUt(){
        try {
             TimeUnit.SECONDS.sleep(3);

        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }


    @GetMapping("/zipkin")
    public String paymentZipkin() {
        return "hi,i`am paymentzipkin server fall back.welcome to github.........";
    }

}



