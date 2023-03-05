package com.example.ss6jwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ss6jwt.dtos.RegisterRequestDTO;
import com.example.ss6jwt.dtos.AuthRequestDTO;
import com.example.ss6jwt.dtos.AuthResponseDTO;
import com.example.ss6jwt.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService; 

	@PostMapping("/register")
	public ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterRequestDTO dto) {
		return ResponseEntity.ok(authService.register(dto));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody AuthRequestDTO dto) {
		System.out.println(getClass().getSimpleName() + ".authenticate");
		return ResponseEntity.ok(authService.authenticate(dto));
	}
}
