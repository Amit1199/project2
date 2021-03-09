package in.edac.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the appointment database table.
 * 
 */
@Entity
@NamedQuery(name="Appointment.findAll", query="SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ap_id")
	private int apId;

	@Temporal(TemporalType.DATE)
	@Column(name="ap_date")
	private Date apDate;

	private String name;

	private String status;

	private Time time;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	private Patient patient;

	//bi-directional many-to-one association to Hospital
	@ManyToOne
	@JoinColumn(name="hsp_id")
	private Hospital hospital;

	public Appointment() {
	}

	public int getApId() {
		return this.apId;
	}

	public void setApId(int apId) {
		this.apId = apId;
	}

	public Date getApDate() {
		return this.apDate;
	}

	public void setApDate(Date apDate) {
		this.apDate = apDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

}