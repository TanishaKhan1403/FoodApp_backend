package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.FoodOrder;
import com.cl.food_app.repository.FoodOrderRepo;
@Repository
public class FoodOrderDAO {
	@Autowired
    private FoodOrderRepo repository;

    
    public FoodOrder saveFoodOrder(FoodOrder foodorder) {
        return repository.save (foodorder);
    }
    public FoodOrder updateFoodOrder(FoodOrder foodorder,int id) {
    	if (repository.findById(id).isEmpty()) {
            return null;
        } else {
            foodorder.setId(id);
            return repository.save(foodorder);
        }
        
    }

    public FoodOrder deleteFoodOrder(int id) {
        
    	FoodOrder foodorder = getFoodOrderById(id).get();
            repository.delete(foodorder);
            return foodorder;
        }
    

    public Optional<FoodOrder> getFoodOrderById(int id) {
        return repository.findById(id);
    }

	
	 public List<FoodOrder> findAllFoodOrder() {
	        return repository.findAll();
	    }

}
