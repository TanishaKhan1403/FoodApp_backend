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
import com.cl.food_app.dto.BranchManager;

import com.cl.food_app.service.BranchManagerService;
import com.cl.food_app.util.ResponseStructure;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class BranchManagerController {



   @Autowired
   BranchManagerService service;
    
    @PostMapping("/savebranchmanager")
    public ResponseEntity<ResponseStructure<BranchManager>> saveBranchManager(@RequestBody BranchManager branchmanager) {
        return service.saveBranchManager(branchmanager);
    }
    
    @PutMapping("/updatebranchmanager/{id}")
    public ResponseEntity<ResponseStructure<BranchManager>> updateBranchManager(@RequestBody BranchManager branchmanager,@PathVariable int id) {
        return service.updateBranchManager(branchmanager,id);
    }
    
    @DeleteMapping("/deletebranchmanager/{id}")
    public ResponseEntity<ResponseStructure<BranchManager>>deleteBranchManager(@RequestParam int id) {
        return service.deleteBranchManager(id);
    }
    
    @GetMapping("/getbranchmanagerbyid/{id}")
    public ResponseEntity<ResponseStructure<BranchManager>>  getBranchManagerById(@PathVariable int id) {
        return service.getBranchManagerById(id);
    }
    
    @GetMapping("/findallbranchmanager")
    public ResponseEntity<ResponseStructure<List<BranchManager>>> findAllBranchManager(){
        return service.findAllBranchManager();
    }
   @PostMapping("/getbymanager")
    
    public BranchManager get(@RequestBody BranchManager branchmanager) throws Exception {
        return service.findbyEmailnPassword(branchmanager);
    }
}
