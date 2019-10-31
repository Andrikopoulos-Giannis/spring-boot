package com.java.springboot.Controllers;

import com.java.springboot.DTOs.OrderDTO;
import com.java.springboot.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/addOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody OrderDTO orderDTO){

        return orderService.create(orderDTO);

    }

    @GetMapping(path = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDTO findById(@RequestParam("id") Long orderId) {

        return orderService.getById(orderId);

    }
}
