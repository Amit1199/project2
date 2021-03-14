package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.enums.AptStatus;

@Entity
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int apId;
	
	@Column(nullable = false)
	private String apDate;
	
	@Column(nullable = false)
	private String time;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private AptStatus aptStatus;

	@Column(nullable = false)
	private int ptId;

	@Column(nullable = false)
	private int hspId;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public AppointmentEntity(AptStatus aptStatus, String apDate, int ptId, int
	 * hspId) { super(); this.aptStatus = aptStatus; this.apDate = apDate; this.ptId
	 * = ptId; this.hspId = hspId; }
	 */
	
	

	public int getAptId() {
		return apId;
	}

	public Appointment(String apDate, String time, AptStatus aptStatus, int ptId, int hspId) {
		super();
		this.apDate = apDate;
		this.time = time;
		this.aptStatus = aptStatus;
		this.ptId = ptId;
		this.hspId = hspId;
	}

	public int getApId() {
		return apId;
	}

	public void setApId(int apId) {
		this.apId = apId;
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

	public AptStatus getAptStatus() {
		return aptStatus;
	}

	public void setAptStatus(AptStatus aptStatus) {
		this.aptStatus = aptStatus;
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
	

	/*
	 * public void setAptId(int aptId) { this.apId = aptId; }
	 * 
	 * public AptStatus isAptStatus() { return aptStatus; }
	 * 
	 * public void setAptStatus(AptStatus aptStatus) { this.aptStatus = aptStatus; }
	 * 
	 * public String getAptDate() { return apDate; }
	 * 
	 * public void setAptDate(String aptDate) { this.apDate = aptDate; }
	 * 
	 * public int getPtId() { return ptId; }
	 * 
	 * public void setPtId(int ptId) { this.ptId = ptId; }
	 * 
	 */

}
