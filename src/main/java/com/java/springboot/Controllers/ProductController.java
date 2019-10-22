package com.java.springboot.Controllers;

import com.java.springboot.DTOs.ProductDTO;
import com.java.springboot.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody ProductDTO productDTO){

       return productService.create(productDTO);

    }

}
