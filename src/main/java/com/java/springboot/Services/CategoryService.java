package com.java.springboot.Services;

import com.java.springboot.DTOs.CategoryDTO;
import com.java.springboot.JpaRepositories.CategoryRepository;
import com.java.springboot.Mappers.CategoryMapper;
import com.java.springboot.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CategoryService {


    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public String create(CategoryDTO categoryDTO){

        try {
            Category category = categoryMapper.DtoToCategory(categoryDTO);
            categoryRepository.save(category);
            return "Category saved Successfully!";
        }catch (Exception ex){
            return "Something went wrong";
        }
    }

    @Transactional
    public CategoryDTO getById(Long categoryId){
        try {
            Category category = categoryRepository.findById(categoryId).get();
            CategoryDTO categoryDTO = categoryMapper.categoryToDTO(category);
            return categoryDTO;
        }catch (Exception ex){
            return null;
        }
    }
}
