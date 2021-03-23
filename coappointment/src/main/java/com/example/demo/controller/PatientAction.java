package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.EmailSenderService;
import com.example.demo.dao.PatientRepository;
import com.example.demo.dto.RegisterStatus;
import com.example.demo.dto.Status.StatusType;
import com.example.demo.model.Patient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
@CrossOrigin
@RequestMapping("/patient")
public class PatientAction {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	EmailSenderService emailSenderService;

	@PostMapping("/register")
	public RegisterStatus createPatient(@RequestBody Patient patient) {
		patientRepository.save(patient);

		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int unqNo = rand.nextInt(1000);
		RegisterStatus status = new RegisterStatus();
		status.setMessage("Patient registered successful");
		status.setStatus(StatusType.SUCCESS);
		status.setRegisteredCustomerNo(patient.getId());

		emailSenderService
				.sendSimpleEmail(patient.getEmail(),
						"You have successfully registered with Covax... You can log with following credentials "
								+ " Username: " + patient.getUsername() + "  Password: " + patient.getPassword(),
						"From Covax!!!");
		return status;
	}

	@GetMapping("/show")
	public List<Patient> getUsers() {

		return patientRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	@GetMapping("/{id}")
	public Patient getPatient(@PathVariable int id) {
		return patientRepository.findById(id).get();
	}

	/*
	 * @PostMapping("/reset/{id}") public boolean updateUser(@PathVariable int
	 * id, @RequestBody Patient patient) { // userRepository.save(user);
	 * 
	 * Patient dbpatient = patientRepository.findById(id).get();
	 * dbpatient.setUsername(patient.getUsername());
	 * dbpatient.setPassword(patient.getPassword());
	 * 
	 * patientRepository.save(dbpatient);
	 * 
	 * return true; }
	 */
	
	@PostMapping("/reset/passd")
	@JsonIgnore
	@JsonBackReference
	public boolean updateUser(@RequestBody Patient patient) {
		// userRepository.save(user);
		
		//
		Patient dbpatient = patientRepository.findByUsername(patient.getUsername());
		/* dbpatient.setUsername(patient.getUsername()); */
		dbpatient.setPassword(patient.getPassword());
		
		patientRepository.save(dbpatient);
		
		return true;
	}

	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable int id) {
		patientRepository.deleteById(id);
	}

	@PostMapping("/resetRequest")
	public String resetRequest(@RequestBody Patient uPatient) {

		Patient patient=patientRepository.findByEmail(uPatient.getEmail());
		if (patient != null) {
			 emailSenderService.sendSimpleEmail(uPatient.getEmail(),
					 "For reset password click on below link... " ,"From Covax!!!");		
			 return "checkMail";
		} else {
			return "You Are Not Registerd Yet,Please Register First to Proceed Further";
		}
		 
		
	}

	@PostMapping("/authPtlogin")
	public Patient authenticatePatient(@RequestBody Patient patient) {
		Patient patient1 = patientRepository.findByUsernameAndPassword(patient.getUsername(), patient.getPassword());
		if (patient1 != null) {

			return patient1;
		} else {

			return patient1;
		}
	}

	/*
	 * @PutMapping("/{id}") public void updatePatient(@PathVariable int
	 * id, @RequestBody Patient user) { patientRepository.save(user); }
	 */

	/*
	 * @PostMapping("/reset") public String updatePassword(@RequestBody Patient
	 * patient) {
	 * patientRepository.findByUsername(patient.getUsername()).save(patient);
	 * 
	 * return "sucess"; }
	 */

}
