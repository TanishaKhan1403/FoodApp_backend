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
import com.cl.food_app.dto.Staff;

import com.cl.food_app.service.StaffService;
import com.cl.food_app.util.ResponseStructure;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class StaffController {



   @Autowired
    StaffService service;
    
    @PostMapping("/savestaff")
    public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff) {
        return service.saveStaff(staff);
    }
    
    @PutMapping("/updatestaff/{id}")
    public ResponseEntity<ResponseStructure<Staff>> updateAdmin(@RequestBody Staff staff,@PathVariable int id) {
        return service.updateStaff(staff,id);
    }
    
    @DeleteMapping("/deletestaff/{id}")
    public ResponseEntity<ResponseStructure<Staff>>  deleteStaff(@PathVariable int id) {
        return service.deleteStaff(id);
    }
    
    @GetMapping("/getstaffbyid/{id}")
    public ResponseEntity<ResponseStructure<Staff>>  getStaffById(@PathVariable int id) {
        return service.getStaffById(id);
    }
    
    @GetMapping("/findallstaff")
    public ResponseEntity<ResponseStructure<List<Staff>>> findAllStaff(){
        return service.findAllStaff();
    }
@PostMapping("/getbystaff")
    
    public Staff get(@RequestBody Staff staff) throws Exception {
        return service.findbyEmailnPassword(staff);
    }
}