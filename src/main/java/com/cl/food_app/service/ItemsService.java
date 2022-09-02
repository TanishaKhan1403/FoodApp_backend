package com.cl.food_app.service;



import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.food_app.dao.ItemsDAO;

import com.cl.food_app.dto.Items;
import com.cl.food_app.exception.IdNotFoundException;

import com.cl.food_app.util.ResponseStructure;



@Service
public class ItemsService {



   @Autowired
   ItemsDAO dao;



   public ResponseEntity<ResponseStructure<Items>> saveItems(Items items) {



	   
       ResponseStructure<Items> structure = new ResponseStructure<Items>();
       structure.setMessage("items saved sucessfully");
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setT(dao.saveItems(items));
        return new ResponseEntity<ResponseStructure<Items>>(structure, HttpStatus.CREATED);
    }



   public ResponseEntity<ResponseStructure<Items>> updateItems(Items items, int id) {
	   Items items2 = dao.updateItems(items, id);
        ResponseStructure<Items> structure = new ResponseStructure<Items>();



       if(items2 != null) {
            structure.setMessage("items updated successfully");
            structure.setStatus(HttpStatus.OK.value());
            structure.setT(items2);
            return  new ResponseEntity<ResponseStructure<Items>>(structure, HttpStatus.OK);
        }
        else {
            structure.setMessage("Invalid Id");
            structure.setStatus(HttpStatus.NOT_FOUND.value());
            structure.setT(items2);
            return  new ResponseEntity<ResponseStructure<Items>>(structure, HttpStatus.NOT_FOUND);
        }
    }



   public ResponseEntity<ResponseStructure<Items>> getItemsById(int id){
        Optional<Items> optional = dao.getItemsById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException();
        } else {
            ResponseStructure<Items> structure = new ResponseStructure<Items>();
            structure.setMessage("items Found successfully");
            structure.setStatus(HttpStatus.OK.value());
            structure.setT(optional.get());
            return new ResponseEntity<ResponseStructure<Items>>(structure, HttpStatus.OK);
        }
    }



   public ResponseEntity<ResponseStructure<List<Items>>> findAllItems() {
        ResponseStructure<List<Items>> structure = new ResponseStructure<List<Items>>();
        structure.setMessage("All items details");
        structure.setStatus(HttpStatus.OK.value());
        structure.setT(dao.findAllItems());
        return new ResponseEntity<ResponseStructure<List<Items>>>(structure, HttpStatus.OK);
    }



   public ResponseEntity<ResponseStructure<Items>> deleteItems(int id) {
        ResponseStructure<Items> structure = new ResponseStructure<Items>();
        structure.setMessage("items deleted successfully");
        structure.setStatus(HttpStatus.OK.value());
        structure.setT(dao.deleteItems(id));
        return new ResponseEntity<ResponseStructure<Items>>(structure, HttpStatus.OK);
    }
}