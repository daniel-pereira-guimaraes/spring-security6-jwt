package com.example.ss6jwt.services;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	@Value("${jwt.secret.key}")
	private String secretKey;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	private SecretKey getKey() {
		return Keys.hmacShaKeyFor(secretKey.getBytes());
	}
	
	public String generateToken(String email) {
		return Jwts.builder()
			.setSubject(email)
			.setExpiration(new Date(System.currentTimeMillis() + expiration))
			.signWith(getKey(), SignatureAlgorithm.HS512)
			.compact();
	}
	

}
