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
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = true)
	private String mobile;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private int aadharNo;
	
	@Column(nullable = false)
	private String coronaPositive;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false, unique = true)
	private String password;
	
	@Column(nullable = false)
	private int pincode;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ptId")
	private List<Appointment> appointments;

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String name, int age, String email, String mobile, String gender, String address, String state,
			int aadharNo, String coronaPositive, String username, String password, int pincode,
			List<Appointment> appointments) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.address = address;
		this.state = state;
		this.aadharNo = aadharNo;
		this.coronaPositive = coronaPositive;
		this.username = username;
		this.password = password;
		this.pincode = pincode;
		this.appointments = appointments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(int aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getCoronaPositive() {
		return coronaPositive;
	}

	public void setCoronaPositive(String coronaPositive) {
		this.coronaPositive = coronaPositive;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	
}
