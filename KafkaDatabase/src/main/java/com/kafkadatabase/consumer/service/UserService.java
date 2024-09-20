//package com.kafkadatabase.consumer.service;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import com.kafkadatabase.consumer.common.User;
//import com.kafkadatabase.consumer.repository.UserRepository;
//
//
//
//@Service
//public class UserService {
//	@Autowired
//	private UserRepository userRepository;
//	
//	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
//	@KafkaListener(topics = "Abc", groupId = "group_id")
//	public User consume(User message)  {
//	logger.info("This is user Topic {}", message.toString());
//		System.out.println("message = " + message);
//		return userRepository.save(message);
//	}
//	
//
//}
