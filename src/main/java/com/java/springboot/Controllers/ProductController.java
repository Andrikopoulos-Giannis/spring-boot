package com.java.springboot.Controllers;

import com.java.springboot.DTOs.GenericResponseDTO;
import com.java.springboot.DTOs.ProductDTO;
import com.java.springboot.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponseDTO create(@Valid @NotNull @RequestBody ProductDTO productDTO){

       return productService.create(productDTO);

    }


    @GetMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO findById(@RequestParam("id") Long productId){
        return productService.getProductById(productId);
    }
}
