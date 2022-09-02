package com.cl.food_app.controller;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




import com.cl.food_app.dto.FoodOrder;

import com.cl.food_app.service.FoodOrderService;
import com.cl.food_app.util.ResponseStructure;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FoodOrderController {



   @Autowired
    FoodOrderService service;
    
    @PostMapping("/savefoodorder")
    public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodorder) {
        return service.saveFoodOrder(foodorder);
    }
    
    @PutMapping("/updatefoodorder/{id}")
    public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder foodorder,@PathVariable int id) {
        return service.updateFoodOrder(foodorder,id);
    }
    
    @DeleteMapping("/deletefoodorder/{id}")
    public ResponseEntity<ResponseStructure<FoodOrder>>deleteFoodOrder(@PathVariable int id) {
        return service.deleteFoodOrder(id);
    }
    
    @GetMapping("/getfoodorderbyid/{id}")
    public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(@PathVariable int id) {
        return service.getFoodOrderById(id);
    }
    
    @GetMapping("/findallfoodorder")
    public ResponseEntity<ResponseStructure<List<FoodOrder>>> findAllFoodOrder(){
        return service.findAllFoodOrder();
    }
}