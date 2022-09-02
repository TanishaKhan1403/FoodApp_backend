package com.cl.food_app.service;



import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;




import com.cl.food_app.dao.BranchManagerDAO;
import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.BranchManager;
import com.cl.food_app.exception.IdNotFoundException;
import com.cl.food_app.util.ASE;
import com.cl.food_app.util.ResponseStructure;



@Service
public class BranchManagerService {



   @Autowired
    BranchManagerDAO dao;



   public ResponseEntity<ResponseStructure<BranchManager>> saveBranchManager(BranchManager branchmanager) {



       String passwordEncrypt = ASE.encrypt(branchmanager.getPassword(), "pass");
       branchmanager.setPassword(passwordEncrypt);
        
        ResponseStructure<BranchManager> structure = new ResponseStructure<BranchManager>();
        structure.setMessage("branchmanager saved sucessfully");
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setT(dao.saveBranchManager(branchmanager));
        return new ResponseEntity<ResponseStructure<BranchManager>>(structure, HttpStatus.CREATED);
    }



   public ResponseEntity<ResponseStructure<BranchManager>> updateBranchManager(BranchManager branchmanager, int id) {
	   BranchManager branchmanager2 = dao.updateBranchManager(branchmanager, id);
        ResponseStructure<BranchManager> structure = new ResponseStructure<BranchManager>();



       if(branchmanager2 != null) {
            structure.setMessage("branchmanager updated successfully");
            structure.setStatus(HttpStatus.OK.value());
            structure.setT(branchmanager2);
            return  new ResponseEntity<ResponseStructure<BranchManager>>(structure, HttpStatus.OK);
        }
        else {
            structure.setMessage("Invalid Id");
            structure.setStatus(HttpStatus.NOT_FOUND.value());
            structure.setT(branchmanager2);
            return  new ResponseEntity<ResponseStructure<BranchManager>>(structure, HttpStatus.NOT_FOUND);
        }
    }



   public ResponseEntity<ResponseStructure<BranchManager>> getBranchManagerById(int id){
        Optional<BranchManager> optional = dao.getBranchManagerById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException();
        } else {
            ResponseStructure<BranchManager> structure = new ResponseStructure<BranchManager>();
            structure.setMessage("branchmanager Found successfully");
            structure.setStatus(HttpStatus.OK.value());
            structure.setT(optional.get());
            return new ResponseEntity<ResponseStructure<BranchManager>>(structure, HttpStatus.OK);
        }
    }



   public ResponseEntity<ResponseStructure<List<BranchManager>>> findAllBranchManager() {
        ResponseStructure<List<BranchManager>> structure = new ResponseStructure<List<BranchManager>>();
        structure.setMessage("All branchmanager details");
        structure.setStatus(HttpStatus.OK.value());
        structure.setT(dao.findAllBranchManager());
        return new ResponseEntity<ResponseStructure<List<BranchManager>>>(structure, HttpStatus.OK);
    }



   public ResponseEntity<ResponseStructure<BranchManager>> deleteBranchManager(int id) {
        ResponseStructure<BranchManager> structure = new ResponseStructure<BranchManager>();
        structure.setMessage("branchmanager deleted successfully");
        structure.setStatus(HttpStatus.OK.value());
        structure.setT(dao.deleteBranchManager(id));
        return new ResponseEntity<ResponseStructure<BranchManager>>(structure, HttpStatus.OK);
    }
   public BranchManager findbyEmailnPassword(BranchManager branchmanager) throws Exception {
	   String passwordEncrypt = ASE.encrypt(branchmanager.getPassword(), "pass");
	   branchmanager.setPassword(passwordEncrypt);
	   String email=branchmanager.getEmail();
	   String password=branchmanager.getPassword();
       BranchManager obj=null;
       if(email!=null && password!=null) {
           obj= dao.findbyEmailnPassword(email,password);
       }
       if(obj==null) {
           throw new Exception("invalid");
       }
       return obj;
      
}
}