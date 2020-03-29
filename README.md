# SpringCloud-Learning-2020
SpringCloud高级版学习

--简介
1.Spingcloud父项目创建，依赖统一管理
2.Spring CLoud 整合注册中心，eureka,zookeeper,consul,nacos
3.服务者（payment）,消费者（order）之间的调用



***环境：

   jdk8,mysql 8.0,maven3.5,centos7(docker)

****服务管理
   springcloud2020
      ————cloud-api-commons                         -----公共管理
      ————cloud-consumer-consul-order-80            -----服务消费者order整合consul
      ————cloud-consumer-eureka-order-80            -----服务消费者order整合eureka
      ————cloud-consumer-zookeeper-order-80         -----服务消费者order整合zookeeper
      ————cloud-eureka-server-7001                  -----eureka注册中心-7001
      ————cloud-eureka-server-7002                  -----eureka注册中心-7002
      ————cloud-provider-consul-payment-8006        -----服务提供者payment整合consul
      ————cloud-provider-eureka-payment-8001        -----服务提供者payment整合eureka-8001       
      ————cloud-provider-eureka-payment-8002        -----服务提供者payment整合eureka-8002       
      ————cloud-provider-zookeeper-payment-8004     -----服务提供者payment整合zookeeper 
   
   
