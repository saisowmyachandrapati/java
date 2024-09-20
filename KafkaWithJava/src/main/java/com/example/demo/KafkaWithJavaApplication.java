package com.example.demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaWithJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaWithJavaApplication.class, args);
		
		Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);


        String topic = "Sample";
        String value = "------->Many ways<-------";

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, value);
        producer.send(record);

        producer.close();
	}

}
