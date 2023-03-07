package com.example.ss6jwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ss6jwt.entities.Person;
import com.example.ss6jwt.enums.Role;

@Service
public class DatabaseService {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void initializeDatabase() {

		System.out.println("Initializing database...");
		
		final Person user1 = new Person("Emma", "emma@mail.com", passwordEncoder.encode("111"));
		final Person user2 = new Person("Jhon", "jhon@mail.com", passwordEncoder.encode("222"));
		final Person admin = new Person("Anna", "anna@mail.com", passwordEncoder.encode("333"));
		
		admin.addRole(Role.ADMIN);
	
		System.out.println(personService.create(user1));
		System.out.println(personService.create(user2));
		System.out.println(personService.create(admin));
		
		System.out.println("Database initialized!");
	}
}
