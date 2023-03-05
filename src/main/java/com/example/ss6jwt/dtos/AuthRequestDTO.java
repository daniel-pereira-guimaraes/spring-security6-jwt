package com.example.ss6jwt.dtos;

public class AuthRequestDTO {
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
