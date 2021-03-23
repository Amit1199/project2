package com.example.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Hospital;


public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	Hospital findByUsernameAndPassword(String username, String password);


	
	//@Query(value = "SELECT * FROM hospital WHERE pincode = ?1", nativeQuery = true)
	List<Hospital> findByPincode(int pincode);
	
	//@Query(value="select h.name from hospital h inner join patient p on h.pincode=p.pincode")
	
}
