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




import com.cl.food_app.dto.Items;

import com.cl.food_app.service.ItemsService;
import com.cl.food_app.util.ResponseStructure;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ItemsController {



   @Autowired
    ItemsService service;
    
    @PostMapping("/saveitems")
    public ResponseEntity<ResponseStructure<Items>> saveItems(@RequestBody Items items) {
        return service.saveItems(items);
    }
    
    @PutMapping("/updateitems/{id}")
    public ResponseEntity<ResponseStructure<Items>> updateItems(@RequestBody Items items,@PathVariable int id) {
        return service.updateItems(items,id);
    }
    
    @DeleteMapping("/deleteitems/{id}")
    public ResponseEntity<ResponseStructure<Items>>  deleteItems(@PathVariable int id) {
        return service.deleteItems(id);
    }
    
    @GetMapping("/getitemsbyid/{id}")
    public ResponseEntity<ResponseStructure<Items>>getItemsById(@PathVariable int id) {
        return service.getItemsById(id);
    }
    
    @GetMapping("/findallitems")
    public ResponseEntity<ResponseStructure<List<Items>>> findAllItems(){
        return service.findAllItems();
    }
}