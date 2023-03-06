package com.example.ss6jwt.dtos;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.ss6jwt.entities.Person;
import com.example.ss6jwt.enums.Role;

public class PersonDTO {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private Set<String> roles = new HashSet<>();
	
	public PersonDTO() {
		super();
	}

	public PersonDTO(Long id, String name, String email, Set<String> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.roles = roles;
	}
	
	public PersonDTO(Person person) {
		super();
		this.id = person.getId();
		this.name = person.getName();
		this.email = person.getEmail();
		this.setRoles(person.getRoles());
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public Set<String> getRoles() {
		return roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles.stream().map(r -> r.getDescription()).collect(Collectors.toSet());
	}
	
}
