package com.example.ss6jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ss6jwt.services.DatabaseService;

@Configuration
public class TestConfig {
	
	@Autowired
	private DatabaseService databaseService;
	
	@Bean
	public void initializeDatabase() {
		databaseService.initializeDatabase();
	}

}
