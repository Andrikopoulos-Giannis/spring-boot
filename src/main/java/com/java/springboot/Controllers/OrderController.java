package com.java.springboot.Controllers;

import com.java.springboot.DTOs.OrderDTO;
import com.java.springboot.Models.Order;
import com.java.springboot.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/product/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody OrderDTO orderDTO){

        return orderService.create(orderDTO);

    }
}
