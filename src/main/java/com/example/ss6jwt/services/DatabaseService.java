package com.example.ss6jwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ss6jwt.entities.Person;

@Service
public class DatabaseService {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void initializeDatabase() {

		System.out.println("Initializing database...");
		
		final Person p1 = new Person("Emma", "emma@mail.com", passwordEncoder.encode("123"));
		final Person p2 = new Person("Jhon", "jhon@mail.com", passwordEncoder.encode("12345"));
		final Person p3 = new Person("Anna", "anna@mail.com", passwordEncoder.encode("1234567890"));
	
		System.out.println(personService.create(p1));
		System.out.println(personService.create(p2));
		System.out.println(personService.create(p3));
		
		System.out.println("Database initialized!");
	}
}
