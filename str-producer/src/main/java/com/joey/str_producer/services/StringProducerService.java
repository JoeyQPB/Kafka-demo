package com.joey.str_producer.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class StringProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topics.first-topic}")
    private String firstTopic;

    public void sendMessage (String message) {
        kafkaTemplate.send(firstTopic, message)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        log.info("Message sent to {}! Partition: {}, Offset: {}",
                                firstTopic,
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());
                    } else {
                        log.error("Error while sent message, to topic {}: {}", firstTopic, message);
                        log.error("Error: ", ex);
                    }
                });
    }
}
