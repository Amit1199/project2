package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.HospitalRepository;
import com.example.demo.dto.RegisterStatus;
import com.example.demo.dto.Status.StatusType;
import com.example.demo.model.Hospital;


@RestController
@RequestMapping("/hospital")
public class HospitalAction {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	@PostMapping("/register")
	public RegisterStatus createHospital(Hospital hospital)
	{
		hospitalRepository.save(hospital);
		
		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int unqNo = rand.nextInt(1000);
	        
	        
		RegisterStatus status=new RegisterStatus();
		status.setMessage("Hospital registered successful");
		status.setStatus(StatusType.SUCCESS);
		status.setRegisteredCustomerNo(unqNo);
		return status;
	}
	
	@GetMapping("/{hspId}")
	public Hospital getHospital(@PathVariable int hspId) {
		return hospitalRepository.findById(hspId).get();
	}

	@GetMapping("/view")
	public List<Hospital> getUsers() {

		return hospitalRepository.findAll(Sort.by(Direction.DESC, "hspId"));
	}

	@PutMapping("/{hspId}")
	public boolean updateUser(@PathVariable int hspId, @RequestBody Hospital hospital) {
		// userRepository.save(user);

		hospitalRepository.save(hospital);

		return true;
	}

	@DeleteMapping("/{hspId}")
	public boolean deleteUser(@PathVariable int hspId) {
		hospitalRepository.deleteById(hspId);
		return true;
	}

	@PostMapping("/AuthentHsplogin")
	public ModelAndView authenticateHospital(String username, String password) {
		Hospital hospital = hospitalRepository.findByUsernameAndPassword(username, password);
		if (hospital != null) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("hospital", hospital);
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("Appointment");
			mv.addObject("ptLogFail", 0);
			return mv;
		}
	}
	
}
