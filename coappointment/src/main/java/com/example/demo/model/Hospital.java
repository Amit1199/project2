package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hospital")
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hspId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String hspAdd;
	
	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private int pincode;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false, unique = true)
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hspId")
	private List<Appointment> appointmentList;

	
	
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Hospital(String name, String hspAdd, String email, int pincode, String username, String password,
			List<Appointment> appointmentList) {
		super();
		this.name = name;
		this.hspAdd = hspAdd;
		this.email = email;
		this.pincode = pincode;
		this.username = username;
		this.password = password;
		this.appointmentList = appointmentList;
	}

	public int getHspId() {
		return hspId;
	}

	public void setHspId(int hspId) {
		this.hspId = hspId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHspAdd() {
		return hspAdd;
	}

	public void setHspAdd(String hspAdd) {
		this.hspAdd = hspAdd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public Hospital(String hspName, String hspAdd, int hspBNo, String
	 * hspUsername, String hspPassword) { super(); this.hspName = hspName;
	 * this.hspAdd = hspAdd; this.hspBNo = hspBNo; this.hspUsername = hspUsername;
	 * this.hspPassword = hspPassword; }
	 */
	
	
	/*
	 * public int getHspId() { return hspId; }
	 * 
	 * public void setHspId(int hspId) { this.hspId = hspId; }
	 * 
	 * public String getHspName() { return hspName; }
	 * 
	 * public void setHspName(String hspName) { this.hspName = hspName; }
	 * 
	 * public String getHspAdd() { return hspAdd; }
	 * 
	 * public void setHspAdd(String hspAdd) { this.hspAdd = hspAdd; }
	 * 
	 * public int getHspBNo() { return hspBNo; }
	 * 
	 * public void setHspBNo(int hspBNo) { this.hspBNo = hspBNo; }
	 * 
	 * public String getHspUsername() { return hspUsername; }
	 * 
	 * public void setHspUsername(String hspUsername) { this.hspUsername =
	 * hspUsername; }
	 * 
	 * public String getHspPassword() { return hspPassword; }
	 * 
	 * public void setHspPassword(String hspPassword) { this.hspPassword =
	 * hspPassword; }
	 */
}


