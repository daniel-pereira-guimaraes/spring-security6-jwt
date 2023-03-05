package com.example.ss6jwt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/ok")
	public ResponseEntity<String> ok() {
		return ResponseEntity.ok("Test ok!");
	}
	
	@GetMapping("/error")
	public ResponseEntity<String> error() {
		throw new RuntimeException("Test error!");
	}
}