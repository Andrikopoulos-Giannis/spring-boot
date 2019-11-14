package com.java.springboot.Mappers;

import com.java.springboot.DTOs.CategoryDTO;
import com.java.springboot.JpaRepositories.CategoryRepository;
import com.java.springboot.Models.Category;
import com.java.springboot.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO categoryToDTO(Category category){

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setParentCategory(category.getParentCategory()!= null ? category.getParentCategory().getId(): null);
        categoryDTO.setSubCategories(category.getSubCategories().stream().map(Category::getId).collect(Collectors.toList()));
        categoryDTO.setProducts(category.getProducts().stream().map(Product::getId).collect(Collectors.toList()));

        return categoryDTO;
    }

    public Category DtoToCategory(CategoryDTO categoryDTO){

        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setParentCategory(categoryDTO.getParentCategory()!= null ? categoryRepository.findById(categoryDTO.getParentCategory()).get(): null);

        return category;
    }
}
