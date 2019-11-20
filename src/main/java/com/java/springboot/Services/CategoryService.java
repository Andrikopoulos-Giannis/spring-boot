package com.java.springboot.Services;

import com.java.springboot.DTOs.CategoryDTO;
import com.java.springboot.DTOs.GenericResponceDTO;
import com.java.springboot.JpaRepositories.CategoryRepository;
import com.java.springboot.Mappers.CategoryMapper;
import com.java.springboot.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CategoryService {


    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public GenericResponceDTO create(CategoryDTO categoryDTO){
        GenericResponceDTO responceDTO = new GenericResponceDTO();
        try {
            Category category = categoryMapper.DtoToCategory(categoryDTO);
            categoryRepository.save(category);
            responceDTO.setMessage("Category saved Successfully!");
            responceDTO.setObject(categoryDTO);
            return responceDTO;
            //TODO:check if exists parentCategory
        }catch (Exception ex){
            responceDTO.setMessage("Something went wrong");
            return responceDTO;
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
