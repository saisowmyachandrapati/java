package com.example.kafkaproducer;



import org.apache.kafka.clients.producer.*;

import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(KafkaProducerApplication.class, args);
		
		Logger logger = LoggerFactory.getLogger(KafkaProducerApplication.class);
		 Properties properties = new Properties();
	        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9093");
	        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	        
	        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);


	        for (int i=0; i<10; i++ ) {
	            ProducerRecord<String, String> record =
	                    new ProducerRecord<String, String>("Hello", "Hello world ");

	            producer.send(record, new Callback() {
	                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
	              if (e == null) {
	                     logger.info("Received new metadata. \n" +
	                                "Topic:" + recordMetadata.topic() + "\n" +
	                                "Partition: " + recordMetadata.partition() + "\n" +
	                                "Offset: " + recordMetadata.offset() + "\n" +
	                                "Timestamp: " + recordMetadata.timestamp());
	                    } else {
	                        logger.error("Error while producing", e);
	                    }
	                }
	            });
	        }

	        producer.flush();
	        producer.close();
		
	}

}
