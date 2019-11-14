package com.java.springboot.Controllers;

import com.java.springboot.DTOs.OrderItemDTO;
import com.java.springboot.Services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class OrderItemControler {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping(path = "/addOrderItem", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(@Valid @RequestBody OrderItemDTO orderItemDTO){
        return orderItemService.create(orderItemDTO);
    }

    @GetMapping(path = "/orderItem", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderItemDTO findById(@RequestParam("id") Long orderItemId){
        return orderItemService.getOrderItemById(orderItemId);
    }
}
