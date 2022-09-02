package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.BranchManager;

import com.cl.food_app.repository.BranchManagerRepo;
@Repository
public class BranchManagerDAO {
	@Autowired
    private BranchManagerRepo repository;

    
    public BranchManager saveBranchManager(BranchManager branchmanager) {
        return repository.save (branchmanager);
    }
    public BranchManager updateBranchManager(BranchManager branchmanager,int id) {
    	if (repository.findById(id).isEmpty()) {
            return null;
        } else {
            branchmanager.setId(id);
            return repository.save(branchmanager);
        }
      
        
    }

    public BranchManager deleteBranchManager(int id) {
        
    	BranchManager branchmanager = getBranchManagerById(id).get();
            repository.delete(branchmanager);
            return branchmanager;
        }
    

    public Optional<BranchManager> getBranchManagerById(int id) {
        return repository.findById(id);
    }

	
	 public List<BranchManager> findAllBranchManager() {
	        return repository.findAll();
	    }
	 public BranchManager findbyEmailnPassword(String email, String password) {
	        
         return (BranchManager) repository.findByEmailAndPassword(email, password);
    
	
}}


