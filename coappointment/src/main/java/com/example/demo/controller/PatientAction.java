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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.EmailSenderService;
import com.example.demo.dao.PatientRepository;
import com.example.demo.dto.RegisterStatus;
import com.example.demo.dto.Status.StatusType;
import com.example.demo.model.Patient;

@RestController
@CrossOrigin
@RequestMapping("/patient")
public class PatientAction {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	EmailSenderService emailSenderService ;
	
	@PostMapping("/register")
	public RegisterStatus createHospital(Patient patient)
	{
		patientRepository.save(patient);
		
		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int unqNo = rand.nextInt(1000);
		RegisterStatus status=new RegisterStatus();
		status.setMessage("Patient registered successful");
		status.setStatus(StatusType.SUCCESS);
		status.setRegisteredCustomerNo(unqNo);
		
		emailSenderService.sendSimpleEmail(patient.getEmail(),
				"You have successfully registered with Covax... You can log with following credentials "
					+" Username: "	+patient.getUsername()  + "  Password: " + patient.getPassword(),
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

	@PutMapping("/{id}")
	public void updatePatient(@PathVariable int id, @RequestBody Patient user) {
		patientRepository.save(user);
	}

	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable int id) {
		patientRepository.deleteById(id);
	}


	@PostMapping("/authPtlogin")
	public ModelAndView Authenticatepatient(String username, String password) {
		Patient patient = patientRepository.findByUsernameAndPassword(username, password);
		if (patient != null) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("patient", patient);
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("Appointment");
			mv.addObject("ptLogFail", 0);
			return mv;
		}
	}
	
}
