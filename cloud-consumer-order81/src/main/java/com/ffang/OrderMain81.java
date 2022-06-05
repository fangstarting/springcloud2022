package com.ffang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program springcloud2022
 * @description
 * @Author FFang
 * @Create 2022-05-31 17:30
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain81.class,args);
    }
}
