package com.emailmessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.emailmessage.common.Email;

@Service
public class EmailService {
	
	private String TOPIC="email-topic";

	@Autowired
	private  KafkaTemplate<String, Email> kafkaTemplate;
	
	public void emailMessage(Email data) {	
		kafkaTemplate.send(TOPIC , data);
		
	}


}
