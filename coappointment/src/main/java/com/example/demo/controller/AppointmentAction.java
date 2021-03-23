package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AppointmentRepository;
import com.example.demo.dto.RegisterStatus;
import com.example.demo.dto.Status.StatusType;
import com.example.demo.model.Appointment;

@RestController
@CrossOrigin
public class AppointmentAction {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@PostMapping("/appointment-register")
	public RegisterStatus createAppointment(Appointment appointment)
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
	
}
