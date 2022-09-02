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




import com.cl.food_app.dto.FoodProduct;

import com.cl.food_app.service.FoodProductService;
import com.cl.food_app.util.ResponseStructure;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FoodProductController {



   @Autowired
   FoodProductService service;
    
    @PostMapping("/savefoodproduct")
    public ResponseEntity<ResponseStructure<FoodProduct>> saveFoodProduct(@RequestBody FoodProduct foodproduct) {
        return service.saveFoodProduct(foodproduct);
    }
    
    @PutMapping("/updatefoodproduct/{id}")
    public ResponseEntity<ResponseStructure<FoodProduct>> updateFoodProduct(@RequestBody FoodProduct foodproduct,@PathVariable int id) {
        return service.updateFoodProduct(foodproduct,id);
    }
    
    @DeleteMapping("/deletefoodproduct/{id}")
    public ResponseEntity<ResponseStructure<FoodProduct>>  deleteFoodProduct(@PathVariable int id) {
        return service.deleteFoodProduct(id);
    }
    
    @GetMapping("/getfoodproductbyid/{id}")
    public ResponseEntity<ResponseStructure<FoodProduct>>  getFoodProductById(@PathVariable int id) {
        return service.getFoodProductById(id);
    }
    
    @GetMapping("/findallfoodproduct")
    public ResponseEntity<ResponseStructure<List<FoodProduct>>> findAllFoodProduct(){
        return service.findAllFoodProduct();
    }
}