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




import com.cl.food_app.dto.Branch;

import com.cl.food_app.service.BranchService;
import com.cl.food_app.util.ResponseStructure;



@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api")
public class BranchController {



   @Autowired
    BranchService service;
    
    @PostMapping("/savebranch")
    public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
        return service.saveBranch(branch);
    }
    
    @PutMapping("/updatebranch/{id}")
    public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch,@PathVariable int id) {
        return service.updateBranch(branch,id);
    }
    
    @DeleteMapping("/deletebranch/{id}")
    public ResponseEntity<ResponseStructure<Branch>>  deleteBranch(@PathVariable int id) {
        return service.deleteBranch(id);
    }
    
    @GetMapping("/getbranchbyid/{id}")
    public ResponseEntity<ResponseStructure<Branch>>  getBranchById(@PathVariable int id) {
        return service.getBranchById(id);
    }
    
    @GetMapping("/findallbranch")
    public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranch(){
        return service.findAllBranch();
    }
}