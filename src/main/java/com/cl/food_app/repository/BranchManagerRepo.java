package com.cl.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.food_app.dto.BranchManager;

public interface BranchManagerRepo extends JpaRepository<BranchManager,Integer>
{

	public BranchManager findByEmailAndPassword(String email, String password);

}
 


