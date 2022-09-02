package com.cl.food_app.service;



import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;





import com.cl.food_app.dao.FoodOrderDAO;

import com.cl.food_app.dto.FoodOrder;
import com.cl.food_app.exception.IdNotFoundException;

import com.cl.food_app.util.ResponseStructure;



@Service
public class FoodOrderService {



   @Autowired
   FoodOrderDAO dao;



   public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodorder) {



       
        
	   ResponseStructure<FoodOrder> structure = new ResponseStructure<FoodOrder>();
       structure.setMessage("foodorder saved sucessfully");
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setT(dao.saveFoodOrder(foodorder));
        return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.CREATED);
    }



   public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder foodorder, int id) {
	   FoodOrder foodorder2 = dao.updateFoodOrder(foodorder, id);
        ResponseStructure<FoodOrder> structure = new ResponseStructure<FoodOrder>();



       if(foodorder2 != null) {
            structure.setMessage("foodorder updated successfully");
            structure.setStatus(HttpStatus.OK.value());
            structure.setT(foodorder2);
            return  new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.OK);
        }
        else {
            structure.setMessage("Invalid Id");
            structure.setStatus(HttpStatus.NOT_FOUND.value());
            structure.setT(foodorder2);
            return  new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.NOT_FOUND);
        }
    }



   public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id){
	   Optional<FoodOrder> optional = dao.getFoodOrderById(id);
       if (optional.isEmpty()) {
           throw new IdNotFoundException();
       } else {
           ResponseStructure<FoodOrder> structure = new ResponseStructure<FoodOrder>();            
           structure.setMessage("foodorder Found successfully");
            structure.setStatus(HttpStatus.OK.value());
            structure.setT(optional.get());
            return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.OK);
        }
    }



   public ResponseEntity<ResponseStructure<List<FoodOrder>>> findAllFoodOrder() {
        ResponseStructure<List<FoodOrder>> structure = new ResponseStructure<List<FoodOrder>>();
        structure.setMessage("All branchmanager details");
        structure.setStatus(HttpStatus.OK.value());
        structure.setT(dao.findAllFoodOrder());
        return new ResponseEntity<ResponseStructure<List<FoodOrder>>>(structure, HttpStatus.OK);
    }



   public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int id) {
        ResponseStructure<FoodOrder> structure = new ResponseStructure<FoodOrder>();
        structure.setMessage("branchmanager deleted successfully");
        structure.setStatus(HttpStatus.OK.value());
        structure.setT(dao.deleteFoodOrder(id));
        return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.OK);
    }
}