package com.kafkaconsumer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafkaconsumer.common.User;
@Service
public class UserService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@KafkaListener(topics = "Abc", groupId = "group_id")
	public List<User> consume(List<User> message)  {
	logger.info("This is user Topic {}", message.toString());
		System.out.println("message = " + message);
		return message;
	}

	
	
}
