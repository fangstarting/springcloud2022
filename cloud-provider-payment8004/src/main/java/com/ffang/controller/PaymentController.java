package com.ffang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

/**
 * @program springcloud2022
 * @description
 * @Author FFang
 * @Create 2022-06-02 13:13
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return "SpringCloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString().replace("-","");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            String[] objects =new String[m];
            for (int i = 0; i <m ; i++) {
                objects[i] = sc.next();
            }
            Arrays.sort(objects);
            StringBuffer sb = new StringBuffer();
            for (String s:objects){
                sb.append(s).append(" ");
            }
            System.out.println(sb);
        }
    }
}
