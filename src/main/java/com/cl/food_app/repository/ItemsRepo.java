package com.cl.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.food_app.dto.Items;

public interface ItemsRepo extends JpaRepository<Items,Integer>{

} 


