package in.edac.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hospital database table.
 * 
 */
@Entity
@NamedQuery(name="Hospital.findAll", query="SELECT h FROM Hospital h")
public class Hospital implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="hsp_id")
	private int hspId;

	private String email;

	@Column(name="hsp_add")
	private String hspAdd;

	private String name;

	private String password;

	@Column(name="pin_code")
	private int pinCode;

	private String username;

	//bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy="hospital")
	private List<Appointment> appointments;

	//bi-directional many-to-many association to Patient
	@ManyToMany
	@JoinTable(
		name="`patient-hospital`"
		, joinColumns={
			@JoinColumn(name="hsp_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id")
			}
		)
	private List<Patient> patients;

	public Hospital() {
	}

	public int getHspId() {
		return this.hspId;
	}

	public void setHspId(int hspId) {
		this.hspId = hspId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHspAdd() {
		return this.hspAdd;
	}

	public void setHspAdd(String hspAdd) {
		this.hspAdd = hspAdd;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPinCode() {
		return this.pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setHospital(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setHospital(null);

		return appointment;
	}

	public List<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}