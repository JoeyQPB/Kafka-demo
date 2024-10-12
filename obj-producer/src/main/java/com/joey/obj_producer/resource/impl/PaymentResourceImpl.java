package com.joey.obj_producer.resource.impl;

import com.joey.obj_producer.model.Payment;
import com.joey.obj_producer.resource.PaymentResource;
import com.joey.obj_producer.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResourceImpl implements PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @Override
    public ResponseEntity<Payment> payment(Payment payment) {
        this.paymentService.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
