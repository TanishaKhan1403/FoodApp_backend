package com.cl.food_app.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Admin;

import com.cl.food_app.repository.AdminRepo;



@Repository
public class AdminDAO {
	
    @Autowired
    private AdminRepo repository;

    
    public Admin saveAdmin(Admin admin) {
        return repository.save(admin);
    }
    public Admin updateAdmin(Admin admin,int id) {
    	if (repository.findById(id).isEmpty()) {
            return null;
        } else {
            admin.setId(id);
            return repository.save(admin);
        }
    	 
      
        
    }

    public Admin deleteAdmin(int id) {
        
           Admin admin = getAdminById(id).get();
            repository.delete(admin);
            return admin;
        }
    

    public Optional<Admin> getAdminById(int id) {
        return repository.findById(id);
    }

    public List<Admin> findAllAdmin() {
        return repository.findAll();
    }
    public Admin findbyEmailnPassword(String email, String password) {
        
            return repository.findByEmailAndPassword(email, password);
       
	
}}
