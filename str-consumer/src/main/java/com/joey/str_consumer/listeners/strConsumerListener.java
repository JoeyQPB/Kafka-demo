package com.joey.str_consumer.listeners;

import com.joey.str_consumer.costumer.StrKafkaCustomListener;
import com.joey.str_consumer.exceptions.ErrorCustomHandler;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class strConsumerListener {

    @StrKafkaCustomListener
    public void create (String msg) {
        log.info("CREATE ::: Message received: {}", msg);
    }

    @StrKafkaCustomListener()
    public void log (String msg) {
        log.info("LOG ::: Message received: {}", msg);
    }

    @SneakyThrows
    @StrKafkaCustomListener(containerFactory = "validMessageContainerFactory")
    public void history (String msg) {
        log.info("HISTORY ::: Message received: {}", msg);
        throw new IllegalArgumentException("=== TEST ILLEGAR ARG EXCT ===");
    }


    @KafkaListener(groupId = "group-1", topics = "str-topic-1", containerFactory = "strContainerFactory")
    public void metric (String msg) {
        log.info("METRIC ::: Message received: {}", msg);
    }

    // setting a specific topic and partition to kafka listener
    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                @TopicPartition(topic = "str-topic-2", partitions = {"0"})
            },
            containerFactory = "strContainerFactory",
            errorHandler = "errorCustomHandler")
    public void bd (String msg) {
        log.info("BD ::: Message received: {}", msg);
    }
}
