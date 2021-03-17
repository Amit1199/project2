package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AdminRepository;
import com.example.demo.model.Admin;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminLogin {

	@Autowired
	AdminRepository adminRepository;
	
	@PostMapping("/register")
	public String createHospital(Admin admin)
	{
		adminRepository.save(admin);
		return "registered success";
	}
	
	@PostMapping("/login")
	public String Authenticatepatient(String username, String password) {
		Admin admin = adminRepository.findByUsernameAndPassword(username, password);
		if (admin != null) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("admin", admin);
			return "success";
		} else {
			ModelAndView mv = new ModelAndView("Appointment");
			mv.addObject("ptLogFail", 0);
			return "fail";
		}
	}
}
