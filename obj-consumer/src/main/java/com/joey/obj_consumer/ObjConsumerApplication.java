package com.joey.obj_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ObjConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObjConsumerApplication.class, args);
	}

}
