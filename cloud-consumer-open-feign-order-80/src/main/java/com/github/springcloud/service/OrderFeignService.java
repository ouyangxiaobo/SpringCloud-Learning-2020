package com.github.springcloud.service;


import com.github.springcloud.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderFeignService {
    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/getPaymentById/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

}
