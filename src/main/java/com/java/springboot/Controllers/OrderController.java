package com.java.springboot.Controllers;

import com.java.springboot.DTOs.FullOrderDTO;
import com.java.springboot.DTOs.GenericResponceDTO;
import com.java.springboot.DTOs.OrderDTO;
import com.java.springboot.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/addOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponceDTO create(@Valid @NotNull @RequestBody OrderDTO orderDTO){

        return orderService.create(orderDTO);

    }

    @GetMapping(path = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDTO findById(@RequestParam("id") Long orderId) {

        return orderService.getById(orderId);

    }

    @GetMapping(path = "/fullOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public FullOrderDTO findFullOrderById(@RequestParam("id") Long orderId) {

        return orderService.getFullOrderById(orderId);

    }

    @GetMapping(path = "/allOrders", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FullOrderDTO> findAllOrdersByCustomerId(@RequestParam("customerId") Long customerId){
        return orderService.getOrdersByCustomerId(customerId);
    }

}
