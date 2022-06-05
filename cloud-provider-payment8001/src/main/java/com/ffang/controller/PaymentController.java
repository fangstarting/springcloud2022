package com.ffang.controller;

import com.ffang.entity.CommonResult;
import com.ffang.entity.Payment;
import com.ffang.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program springcloud2022
 * @description
 * @Author FFang
 * @Create 2022-05-31 16:06
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:"+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("****查询结果：" + paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "查询成功,serverPort:"+serverPort, paymentById);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID" + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(e->log.info("****element:"+e));
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(i->log.info(i.getServiceId()+"\t"+i.getHost()+"\t"+i.getPort()+"\t"+i.getUri()));
        return this.discoveryClient;
    }
}
