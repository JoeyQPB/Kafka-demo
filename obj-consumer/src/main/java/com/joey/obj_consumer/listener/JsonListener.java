package com.joey.obj_consumer.listener;

import com.joey.obj_consumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) {
        log.info("Received request: {}", payment.toString());
        Thread.sleep(2000);

        log.info("Validating fraud...");
        Thread.sleep(2000);

        log.info("Approved...");
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) {
        Thread.sleep(5000);
        log.info("Generating PDF for ID: {}...", payment.getId());
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void emailSender() {
        Thread.sleep(10000);
        log.info("Sending email...");
    }
}
