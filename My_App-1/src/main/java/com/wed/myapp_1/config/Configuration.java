package com.wed.myapp_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;



public class Configuration {
	
	  @Bean
	    public WebClient.Builder webClientBuilder() {
	        return WebClient.builder()
	            .baseUrl("http://example.com")
	            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
	    }
	

}
