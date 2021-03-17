package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	private final int id=1;

	@Column(nullable = false)
	private final String name;
	@Column(nullable = false)
	private final String username;
	@Column(nullable = false)
	private final String password;
	
	
	public Admin() {
		
		super();
		this.name = "admin";
		this.username = "admin";
		this.password = "p@ssw0rd)";
	}

	
	
	
	
}
