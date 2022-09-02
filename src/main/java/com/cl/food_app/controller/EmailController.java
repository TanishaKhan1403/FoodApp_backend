package com.cl.food_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cl.food_app.dto.Customer;
import com.cl.food_app.util.EmailService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EmailController {
	@Autowired
	EmailService emailservice;
	@GetMapping("/sendemail/{id}")
	public String mail(@PathVariable int id) {
		return emailservice.sendEmail(id);
	}

}
