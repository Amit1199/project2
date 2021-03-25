package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EmailSenderService;
import com.example.demo.dao.AppointmentRepository;
import com.example.demo.dto.RegisterStatus;
import com.example.demo.dto.Status.StatusType;
import com.example.demo.model.Appointment;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentAction {

	@Autowired
	private AppointmentRepository appointmentRepository;
	

	@Autowired
	private EmailSenderService emailSenderService;

	
	@PostMapping("/appointment-register")
	public RegisterStatus createAppointment(@RequestBody Appointment appointment)
	{
		appointmentRepository.save(appointment);
		
		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int unqNo = rand.nextInt(1000);
		
		RegisterStatus status=new RegisterStatus();
		status.setMessage("Appointment registered successful");
		status.setStatus(StatusType.SUCCESS);
		status.setRegisteredCustomerNo(unqNo);
		return status;
	}
	
	
	@PostMapping("/appointment-confirmation/{email}")
	public RegisterStatus updateUser(@PathVariable String email) {
		RegisterStatus status = new RegisterStatus();
		status.setMessage("Patient registered successful");
		status.setStatus(StatusType.SUCCESS);
		
		emailSenderService
		.sendSimpleEmail(email,"Your Appointment Status: "+status.getStatus()+" \nOn date: "+" \nSo Come to Hospital with aadhar card on allocated time!!","Appointment Confirmation");
		return status;
	}
	
}
