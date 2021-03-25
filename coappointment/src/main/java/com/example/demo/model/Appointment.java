package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int apId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	
	@Column(nullable = false)
	private String apDate;
	
	@Column(nullable = false)
	private String time;

	/*
	 * // @Column(nullable = false) // @Enumerated(EnumType.STRING) // private
	 * AptStatus aptStatus;
	 */
	@Column(nullable = false)
	private int ptId;

	@Column(nullable = false)
	private int hspId;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Appointment(String name, String email, String apDate, String time, int ptId, int hspId) {
		super();
		this.name = name;
		this.email = email;
		this.apDate = apDate;
		this.time = time;
		this.ptId = ptId;
		this.hspId = hspId;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getApId() {
		return apId;
	}

	public void setApId(int apId) {
		this.apId = apId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApDate() {
		return apDate;
	}

	public void setApDate(String apDate) {
		this.apDate = apDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	public int getPtId() {
		return ptId;
	}

	public void setPtId(int ptId) {
		this.ptId = ptId;
	}

	public int getHspId() {
		return hspId;
	}

	public void setHspId(int hspId) {
		this.hspId = hspId;
	}
	

}
