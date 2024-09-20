package com.wed.myapp_1.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wed.myapp_1.common.User;
import com.wed.myapp_1.repository.UserRepository;
import com.wed.myapp_1.service.UserService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = {"http://localhost:8088","*"})
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/getUser")
	public List<User> getUser(){
		return userRepository.findAll();	
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@RequestBody User user,@PathVariable ("id") int id) {
		return userService.updateUser(user , id);
		
	}
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable ("id") int id) {
		return userService.getUserById(id);
		
	}

}
