package com.java.springboot.Controllers;

import com.java.springboot.Models.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping(path = "/product/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody Order order){

        return  "Product saved Successfully";

    }
}
