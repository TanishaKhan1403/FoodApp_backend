package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Items;
import com.cl.food_app.repository.ItemsRepo;




@Repository
public class ItemsDAO {
	@Autowired
    private ItemsRepo repository;

    
    public Items saveItems(Items items) {
        return repository.save (items);
    }
    public Items updateItems(Items items,int id) {
    	if (repository.findById(id).isEmpty()) {
            return null;
        } else {
            items.setId(id);
            return repository.save(items);
        }
        
    }

    public Items deleteItems(int id) {
        
    	Items items = getItemsById(id).get();
            repository.delete(items);
            return items;
        }
    

    public Optional<Items> getItemsById(int id) {
        return repository.findById(id);
    }

	
	 public List<Items> findAllItems() {
	        return repository.findAll();
	    }

}
