package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Staff;
import com.cl.food_app.repository.StaffRepo;



@Repository
public class StaffDAO {
	@Autowired
    private StaffRepo repository;

    
    public Staff saveStaff(Staff staff) {
        return repository.save (staff);
    }
    public Staff updateStaff(Staff staff,int id) {
    	if (repository.findById(id).isEmpty()) {
            return null;
        } else {
            staff.setId(id);
            return repository.save(staff);
        }
        
    }

    public Staff deleteStaff(int id) {
        
    	Staff staff = getStaffById(id).get();
            repository.delete(staff);
            return staff;
        }
    

    public Optional<Staff> getStaffById(int id) {
        return repository.findById(id);
    }

	
	 public List<Staff> findAllStaff() {
	        return repository.findAll();
	    }
	 public Staff findbyEmailnPassword(String email, String password) {
	        
         return (Staff) repository.findByEmailAndPassword(email, password);

}}
