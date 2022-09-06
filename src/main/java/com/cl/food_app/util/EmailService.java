package com.cl.food_app.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cl.food_app.dao.FoodOrderDAO;
import com.cl.food_app.dto.Customer;
import com.cl.food_app.dto.FoodOrder;

@Service
public class EmailService {
	@Autowired
	JavaMailSender javaMailSender;
    @Autowired
	FoodOrderDAO dao;
    @Autowired
Customer customer;
    public String sendEmail(int id) {
        SimpleMailMessage message=new SimpleMailMessage();
        FoodOrder foodOrder=dao.getFoodOrderById(id).get();
        customer.setGST(0.18);
        customer.setServiceCost(10);
//        double total=foodOrder.getPrice();
//        customer.setCost(total+(total*customer.getGST())+total*customer.getServiceCost());
        message.setFrom("manju8105635884@gmail.com");
        message.setTo("manju8105635884@gmail.com");
        message.setSubject("Test Subject");
//        message.setText("Your Order Id is=" +foodOrder.getId()+"\n" + " Your Food Price is="+foodOrder.getPrice()+"\n"+" GST=1%,Service=1%."+"\n" +"Total Price="+customer.getCost());
        javaMailSender.send(message);
        return message.getText();
        
    }
}
