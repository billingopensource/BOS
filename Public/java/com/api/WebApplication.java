package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.filter.CharacterEncodingFilter;


import javax.servlet.Filter;

@Configuration
@SpringBootApplication
public class WebApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
	
	@Bean
	 public Filter characterEncodingFilter() {
		 CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	     characterEncodingFilter.setEncoding("UTF-8");
	     characterEncodingFilter.setForceEncoding(true);
	     return characterEncodingFilter;
	 }
	
	

}
