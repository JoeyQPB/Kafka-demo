package com.joey.str_consumer.costumer;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;
import com.joey.str_consumer.exceptions.ErrorCustomHandler;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@KafkaListener
public @interface StrKafkaCustomListener {

    @AliasFor (annotation = KafkaListener.class, attribute = "topics")
    String[] topics() default "str-topic-1";

    @AliasFor (annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "strContainerFactory";

    @AliasFor (annotation = KafkaListener.class, attribute = "groupId")
    String groupId() default "group-0";

    @AliasFor (annotation = KafkaListener.class, attribute = "errorHandler")
    String errorHandler() default "errorCustomHandler";
}
