package com.kafkadatabase.consumer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkadatabase.consumer.common.User;
import com.kafkadatabase.consumer.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@KafkaListener(topics = "UserInfo", groupId = "Abc")
	public void consume(String message) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			User user = objectMapper.readValue(message, User.class);

			logger.info("This is UserInfo Topic {}", message.toString());
			System.out.println("message = " + message);
			userRepository.save(user);

		} catch (Exception e) {
			logger.error("Exception message", e);
		}
	}

}
