package com.cl.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.food_app.dto.Staff;

public interface StaffRepo extends JpaRepository<Staff,Integer>{

	public Staff findByEmailAndPassword(String email, String password);

} 


