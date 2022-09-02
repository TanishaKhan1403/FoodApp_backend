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



import com.cl.food_app.dto.Admin;
import com.cl.food_app.service.AdminService;
import com.cl.food_app.util.ResponseStructure;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class AdminController {



   @Autowired
    AdminService service;
    
    @PostMapping("/saveadmin")
    public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
        return service.saveAdmin(admin);
    }
    
    @PutMapping("/editadmin/{id}")
    public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin,@PathVariable int id) {
        return service.updateAdmin(admin,id);
    }
    
    @DeleteMapping("/deleteadmin/{id}")
    public ResponseEntity<ResponseStructure<Admin>>  deleteAdmin(@PathVariable int id) {
        return service.deleteAdmin(id);
    }
    
    @GetMapping("/getadminbyid/{id}")
    public ResponseEntity<ResponseStructure<Admin>>  getAdminById(@PathVariable int id) {
        return service.getAdminById(id);
    }
    
    @GetMapping("/findalladmin")
    public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmin(){
        return service.findAllAdmin();
    }
    
    
    @PostMapping("/getby")
    
    public Admin get(@RequestBody Admin admin) throws Exception {
        return service.findbyEmailnPassword(admin);
    }
}