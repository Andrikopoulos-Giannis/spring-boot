package com.java.springboot.Controllers;

import com.java.springboot.DTOs.CustomerDTO;
import com.java.springboot.DTOs.GenericResponseDTO;
import com.java.springboot.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/SignUp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponseDTO create(@Valid @NotNull @RequestBody CustomerDTO customerDTO) {

        return customerService.create(customerDTO);
    }

    @GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO findById(@RequestParam("id") Long customerId){

        return customerService.getById(customerId);

    }
}
