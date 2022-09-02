package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.FoodProduct;
import com.cl.food_app.repository.FoodProductRepo;




@Repository
public class FoodProductDAO {
	@Autowired
    private FoodProductRepo repository;

    
    public FoodProduct saveFoodProduct(FoodProduct foodproduct) {
        return repository.save (foodproduct);
    }
    public FoodProduct updateFoodProduct(FoodProduct foodproduct,int id) {
    	if (repository.findById(id).isEmpty()) {
            return null;
        } else {
            foodproduct.setId(id);
            return repository.save(foodproduct);
        }
      
        
    }

    public FoodProduct deleteFoodProduct(int id) {
        
    	FoodProduct foodproduct = getFoodProductById(id).get();
            repository.delete(foodproduct);
            return foodproduct;
        }
    

    public Optional<FoodProduct> getFoodProductById(int id) {
        return repository.findById(id);
    }

	
	 public List<FoodProduct> findAllFoodProduct() {
	        return repository.findAll();
	    }

}
