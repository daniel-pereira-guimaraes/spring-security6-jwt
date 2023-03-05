package com.example.ss6jwt.entities;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.ss6jwt.enums.Role;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	private String password;
	private Set<Integer> roles;
	
	public Person() {
		super();
	}

	public Person(Long id, String name, String email, String password, Set<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.setRoles(roles);
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

	public Set<Role> getRoles() {
		return roles.stream().map(r -> Role.fromId(r)).collect(Collectors.toSet());
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
		this.roles = roles.stream().map(r -> r.getId()).collect(Collectors.toSet());
	}
	
}
