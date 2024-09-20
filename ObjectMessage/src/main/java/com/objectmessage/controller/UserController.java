package com.objectmessage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.objectmessage.common.User;
import com.objectmessage.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/userInfo")
	public  String userInfo(@RequestBody List<User> user) {
		userService.userdata(user);
		System.out.println("---->"+user.toString());
		return "Done";
		
	}

}
