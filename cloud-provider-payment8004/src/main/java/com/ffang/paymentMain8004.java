package com.ffang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program springcloud2022
 * @description
 * @Author FFang
 * @Create 2022-06-02 13:11
 */
@SpringBootApplication
@EnableDiscoveryClient  //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class paymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(paymentMain8004.class,args);
    }
}
