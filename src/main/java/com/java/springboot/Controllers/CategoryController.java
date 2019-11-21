package com.java.springboot.Controllers;

import com.java.springboot.DTOs.CategoryDTO;
import com.java.springboot.DTOs.GenericResponseDTO;
import com.java.springboot.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "/addCategory", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponseDTO create(@Valid @RequestBody CategoryDTO categoryDTO){
        return categoryService.create(categoryDTO);
    }

    @GetMapping(path = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryDTO findById(@RequestParam("id") Long categoryId){
        return categoryService.getById(categoryId);
    }
}
