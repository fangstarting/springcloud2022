package com.ffang.service;

import com.ffang.entity.Payment;

/**
 * @program springcloud2022
 * @description
 * @Author FFang
 * @Create 2022-05-31 16:03
 */
public interface PaymentService {

     int create(Payment payment);

     Payment getPaymentById(Long id);

}
