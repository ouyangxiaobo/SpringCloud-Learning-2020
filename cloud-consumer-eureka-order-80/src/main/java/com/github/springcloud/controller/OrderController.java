package com.github.springcloud.controller;

import com.github.springcloud.common.CommonResult;
import com.github.springcloud.entities.Payment;
import com.github.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;


/**
 * author: ouyang
 * Date:2020/3/28 17:09
 **/
@RestController
@Slf4j
public class OrderController {

    //public static  final String PAY_URL="http://localhost:8001";

    //通过服务名进行负载均衡访问
    public static  final String PAY_URL="http://CLOUD-PAYMENT-SERVICE";



    @Resource
    private RestTemplate restTemplate;


    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/create")
    public CommonResult<Payment> createPayment(Payment payment){

        return restTemplate.postForObject(PAY_URL+"/payment/create", payment,CommonResult.class );

    }

    @GetMapping("/consumer/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        log.info("id="+id);

        return restTemplate.getForObject(PAY_URL+"/payment/getPaymentById/"+id,CommonResult.class );

    }

    @GetMapping("/consumer/createEntity")
    public CommonResult<Payment> createEntity(Payment payment){

        ResponseEntity body = restTemplate.postForEntity(PAY_URL + "/payment/create", payment, CommonResult.class);
        if(body.getStatusCode().is2xxSuccessful()){
            return new CommonResult(200,"操作成功",body);
        }else {
            return new CommonResult(404,"操作失败",null);
        }

    }


    @GetMapping("/consumer/getPaymentEntity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Long id){

        ResponseEntity body = restTemplate.getForEntity(PAY_URL+"/payment/getPaymentById/"+id, CommonResult.class);
        if(body.getStatusCode().is2xxSuccessful()){
            return new CommonResult(200,"操作成功",body);
        }else {
            return new CommonResult(404,"操作失败",null);
        }

    }



    /**
     * 路由规则: 轮询
     * http://localhost/consumer/payment/payment/lb
     *
     * @return
     */
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }


}
