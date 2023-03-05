package com.example.ss6jwt.services;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
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
	
	public String generateToken(String username) {
		return Jwts.builder()
			.setSubject(username)
			.setExpiration(new Date(System.currentTimeMillis() + expiration))
			.signWith(getKey(), SignatureAlgorithm.HS512)
			.compact();
	}
	
	public Claims getClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
	}

}
