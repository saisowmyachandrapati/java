package com.emailmessage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emailmessage.common.Email;
import com.emailmessage.service.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/emailPost")
	public String sendEmail(@RequestBody Email email) {
		emailService.emailMessage(email);
		return "Successfully Done";
		
	}
	@RequestMapping(value = "/Test" , method=RequestMethod.GET)
	public String getEmail() {
		
		return "Successfully Done";
		
	}
	
}
