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

import com.example.demo.dao.HospitalRepository;
import com.example.demo.dto.RegisterStatus;
import com.example.demo.dto.Status.StatusType;
import com.example.demo.model.Appointment;
import com.example.demo.model.Hospital;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/hospital")
public class HospitalAction {

	@Autowired
	private HospitalRepository hospitalRepository;

	@PostMapping("/register")
	public RegisterStatus createHospital(@RequestBody Hospital hospital) {
		hospitalRepository.save(hospital);

		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int unqNo = rand.nextInt(1000);

		RegisterStatus status = new RegisterStatus();
		status.setMessage("Hospital registered successful");
		status.setStatus(StatusType.SUCCESS);
		status.setRegisteredCustomerNo(unqNo);
		return status;
	}

	@PostMapping("/nearBy")
	public List<Hospital> getHospital(@RequestBody Hospital hospital) {
		List<Hospital> list = hospitalRepository.findByPincode(hospital.getPincode());
		return list;
	}

	@GetMapping("/{id}")
	public List<Appointment> getPatient(@PathVariable int id) {

		Hospital hospital = hospitalRepository.findById(id).get();
		return hospital.getAppointmentList();
	}

	@GetMapping("/view")
	public List<Hospital> getUsers() {

		return hospitalRepository.findAll(Sort.by(Direction.DESC, "hspId"));
	}


	@DeleteMapping("/{hspId}")
	public boolean deleteUser(@PathVariable int hspId) {
		hospitalRepository.deleteById(hspId);
		return true;
	}

	@PostMapping("/AuthentHsplogin")
	public Hospital authenticateHospital(@RequestBody Hospital hospital) {
		Hospital hospital1 = hospitalRepository.findByUsernameAndPassword(hospital.getUsername(),
				hospital.getPassword());
		return hospital1;
	}

}
