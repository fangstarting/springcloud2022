package com.ffang.service.impl;

import com.ffang.dao.PaymentDao;
import com.ffang.entity.Payment;
import com.ffang.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program springcloud2022
 * @description
 * @Author FFang
 * @Create 2022-05-31 16:03
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
