package com.joey.obj_producer.service.impl;

import com.joey.obj_producer.model.Payment;
import com.joey.obj_producer.service.PaymentService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Payment received: {}", payment);
        Thread.sleep(1500);

        log.info("Sending Payment...");
        this.kafkaTemplate.send("payment-topic", payment);
    }
}
