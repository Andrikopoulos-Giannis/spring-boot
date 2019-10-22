package com.java.springboot.Controllers;

import com.java.springboot.DTOs.CustomerDTO;
import com.java.springboot.Services.CustomerService;
import com.mysql.cj.x.protobuf.Mysqlx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/SignUp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody CustomerDTO customer){
        customerService.create(customer);
        return  "Sign up Successfully";
    }
}
