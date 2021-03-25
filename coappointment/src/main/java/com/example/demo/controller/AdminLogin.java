package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AdminRepository;
import com.example.demo.model.Admin;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class AdminLogin {

	@Autowired
	AdminRepository adminRepository;
	
	@PostMapping("/register")
	public String createAdmin(Admin admin)
	{
		adminRepository.save(admin);
		return "registered success";
	}
	
	@PostMapping("/login")
	public Admin authenticatepatient(@RequestBody Admin admin) {
		Admin admin1 = adminRepository.findByUsernameAndPassword(admin.getUsername(),admin.getPassword());
	
		return admin1;
	}
}
