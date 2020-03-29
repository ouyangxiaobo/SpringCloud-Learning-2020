package com.github.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author: ouyang
 * Date:2020/3/29 14:46
 **/

/*
* 由于官方说明，自定义负载均衡算法，不能跟springboot同包同类和子包子类，也就是不能被ComponentScan扫描到
* 所以，要在上一层创建包和类
*
*
* 负载均衡算法：
*
* rest接口第几次访问数 % 服务者集群数量 =实际调用服务器位置下标，每次服务重新启动后，rest接口计数从1 开始
*
* List<ServiceInstance> instances=discoveryClient.getIntances("COLUD-PAYMENT-SERVICE")
* 如：
*  List[0] instances=127.0.0.1:8002
*  List[1] instances=127.0.0.1:8001
*
*  8001+8002组成集群，他们共两台机器，集群总数为2，按照轮询算法原理
*
*  当总请求数为1时：1 % 2 =1 对应下标位置为1 ，则获得服务地址为127.0.0.1：8081
*  当总请求数为2时：1 % 2 =0 对应下标位置为0 ，则获得服务地址为127.0.0.1：8082
*  当总请求数为3时：1 % 2 =1 对应下标位置为1，则获得服务地址为127.0.0.1：8081
*  当总请求数为4时：1 % 2 =0 对应下标位置为0，则获得服务地址为127.0.0.1：8082
* */


@Configuration
public class MySelfRule {

    /*随机算法*/
    @Bean
    public IRule myRulea(){
        return  new RandomRule();
    }
}
