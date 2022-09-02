package com.cl.food_app.service;



import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import com.cl.food_app.dao.AdminDAO;
import com.cl.food_app.dto.Admin;
import com.cl.food_app.exception.IdNotFoundException;
import com.cl.food_app.util.ASE;
import com.cl.food_app.util.ResponseStructure;



@Service
public class AdminService {



   @Autowired
    AdminDAO dao;



   public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {



       String passwordEncrypt = ASE.encrypt(admin.getPassword(), "pass");
        admin.setPassword(passwordEncrypt);
        
        ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
        structure.setMessage("admin saved sucessfully");
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setT(dao.saveAdmin(admin));
        return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
    }



   public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin, int id) {
        Admin admin2 = dao.updateAdmin(admin, id);
        ResponseStructure<Admin> structure = new ResponseStructure<Admin>();



       if(admin2 != null) {
            structure.setMessage("Admin updated successfully");
            structure.setStatus(HttpStatus.OK.value());
            structure.setT(admin2);
            return  new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
        }
        else {
            structure.setMessage("Invalid Id");
            structure.setStatus(HttpStatus.NOT_FOUND.value());
            structure.setT(admin2);
            return  new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.NOT_FOUND);
        }
    }



   public ResponseEntity<ResponseStructure<Admin>> getAdminById(int id){
        Optional<Admin> optional = dao.getAdminById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException();
        } else {
            ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
            structure.setMessage("Admin Found successfully");
            structure.setStatus(HttpStatus.OK.value());
            structure.setT(optional.get());
            return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
        }
    }



   public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmin() {
        ResponseStructure<List<Admin>> structure = new ResponseStructure<List<Admin>>();
        structure.setMessage("All Admin details");
        structure.setStatus(HttpStatus.OK.value());
        structure.setT(dao.findAllAdmin());
        return new ResponseEntity<ResponseStructure<List<Admin>>>(structure, HttpStatus.OK);
    }



   public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int id) {
        ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
        structure.setMessage("Admin deleted successfully");
        structure.setStatus(HttpStatus.OK.value());
        structure.setT(dao.deleteAdmin(id));
        return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
    }
   public Admin findbyEmailnPassword(Admin admin) throws Exception {
	   String passwordEncrypt = ASE.encrypt(admin.getPassword(), "pass");
       admin.setPassword(passwordEncrypt);
	   String email=admin.getEmail();
	   String password=admin.getPassword();
       Admin obj=null;
       if(email!=null && password!=null) {
           obj= dao.findbyEmailnPassword(email,password);
       }
       if(obj==null) {
           throw new Exception("invalid");
       }
       return obj;
      
}}