package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Hospital;


public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	Hospital findByUsernameAndPassword(String username, String password);
}
