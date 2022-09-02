package com.cl.food_app.service;




import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cl.food_app.dao.MenuDAO;

import com.cl.food_app.dto.Menu;

import com.cl.food_app.exception.IdNotFoundException;
import com.cl.food_app.util.ResponseStructure;



@Service
public class MenuService {



   @Autowired
   MenuDAO dao;



   public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {



     
	   ResponseStructure<Menu> structure = new ResponseStructure<Menu>();
       structure.setMessage("items saved sucessfully");
       structure.setStatus(HttpStatus.CREATED.value());
       structure.setT(dao.saveMenu(menu));
       return new ResponseEntity<ResponseStructure<Menu>>(structure, HttpStatus.CREATED);
   }



   public ResponseEntity<ResponseStructure<Menu>>updateMenu(Menu menu, int id) {
	   Menu menu2 = dao.updateMenu(menu, id);
        ResponseStructure<Menu> structure = new ResponseStructure<Menu>();



        if(menu2 != null) {
            structure.setMessage("menu updated successfully");
            structure.setStatus(HttpStatus.OK.value());
            structure.setT(menu2);
            return  new ResponseEntity<ResponseStructure<Menu>>(structure, HttpStatus.OK);
        }
        else {
            structure.setMessage("Invalid Id");
            structure.setStatus(HttpStatus.NOT_FOUND.value());
            structure.setT(menu2);
            return  new ResponseEntity<ResponseStructure<Menu>>(structure, HttpStatus.NOT_FOUND);
        }
    }



   public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id){
        Optional<Menu> optional = dao.getMenuById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException();
        } else {
            ResponseStructure<Menu> structure = new ResponseStructure<Menu>();
            structure.setMessage("staff Found successfully");
            structure.setStatus(HttpStatus.OK.value());
            structure.setT(optional.get());
            return new ResponseEntity<ResponseStructure<Menu>>(structure, HttpStatus.OK);
        }
    }



   public ResponseEntity<ResponseStructure<List<Menu>>> findAllMenu() {
        ResponseStructure<List<Menu>> structure = new ResponseStructure<List<Menu>>();
        structure.setMessage("All menu details");
        structure.setStatus(HttpStatus.OK.value());
        structure.setT(dao.findAllMenu());
        return new ResponseEntity<ResponseStructure<List<Menu>>>(structure, HttpStatus.OK);
    }



   public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int id) {
        ResponseStructure<Menu> structure = new ResponseStructure<Menu>();
        structure.setMessage("items deleted successfully");
        structure.setStatus(HttpStatus.OK.value());
        structure.setT(dao.deleteMenu(id));
        return new ResponseEntity<ResponseStructure<Menu>>(structure, HttpStatus.OK);
    }
}