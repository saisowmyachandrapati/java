package com.example.emailmessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.emailmessage.common.Email;

@SpringBootApplication
@ComponentScan("com.emailmessage")
public class EmailMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailMessageApplication.class, args);
		
		
	
	}

}
