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




import com.cl.food_app.dto.Menu;

import com.cl.food_app.service.MenuService;
import com.cl.food_app.util.ResponseStructure;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MenuController {



   @Autowired
    MenuService service;
    
    @PostMapping("/savemenu")
    public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu) {
        return service.saveMenu(menu);
    }
    
    @PutMapping("/updatemenu/{id}")
    public ResponseEntity<ResponseStructure<Menu>> updateAdmin(@RequestBody Menu menu,@PathVariable int id) {
        return service.updateMenu(menu,id);
    }
    
    @DeleteMapping("/deletemenu/{id}")
    public ResponseEntity<ResponseStructure<Menu>>deleteMenu(@PathVariable int id) {
        return service.deleteMenu(id);
    }
    
    @GetMapping("/getmenubyid/{id}")
    public ResponseEntity<ResponseStructure<Menu>>  getMenuById(@PathVariable int id) {
        return service.getMenuById(id);
    }
    
    @GetMapping("/findallmenu")
    public ResponseEntity<ResponseStructure<List<Menu>>> findAllMenu(){
        return service.findAllMenu();
    }
}