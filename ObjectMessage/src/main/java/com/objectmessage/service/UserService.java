package com.objectmessage.service;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import com.objectmessage.common.User;

@Service
public class UserService {

	
	private String topic="UserInfo";
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private KafkaTemplate<String, User> kafkatempleate;
	
	
	 public void userdata(List<User> userList) {
		 
		 for (User user : userList) {
	            logger.info("Sending user: {}", user.toString());
	            kafkatempleate.send(topic, user);
	        }
	 }
	
}
