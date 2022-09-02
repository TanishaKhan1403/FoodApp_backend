package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Menu;
import com.cl.food_app.repository.MenuRepo;



@Repository
public class MenuDAO {
	@Autowired
    private MenuRepo repository;

    
    public Menu saveMenu(Menu menu) {
        return repository.save (menu);
    }
    public Menu updateMenu(Menu menu,int id) {
    	if (repository.findById(id).isEmpty()) {
            return null;
        } else {
            menu.setId(id);
            return repository.save(menu);
        }
      
        
    }

    public Menu deleteMenu(int id) {
        
    	Menu menu = getMenuById(id).get();
            repository.delete(menu);
            return menu;
        }
    

    public Optional<Menu> getMenuById(int id) {
        return repository.findById(id);
    }

	
	 public List<Menu> findAllMenu() {
	        return repository.findAll();
	    }

}
