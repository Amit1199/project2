package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}