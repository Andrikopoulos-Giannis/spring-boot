package com.java.springboot.Services;

import com.java.springboot.DTOs.CategoryDTO;
import com.java.springboot.DTOs.GenericResponseDTO;
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
    public GenericResponseDTO create(CategoryDTO categoryDTO){
        GenericResponseDTO responseDTO = new GenericResponseDTO();
        try {
            Category category = categoryMapper.DtoToCategory(categoryDTO);
            categoryRepository.save(category);
            responseDTO.setMessage("Category saved Successfully!");
            responseDTO.setObject(categoryDTO);
            return responseDTO;
            //TODO:check if exists parentCategory
        }catch (Exception ex){
            responseDTO.setMessage("Something went wrong");
            return responseDTO;
        }
    }

    @Transactional
    public CategoryDTO getById(Long categoryId){
        try {
            Optional<Category> category = categoryRepository.findById(categoryId);
            return category.map(value -> categoryMapper.categoryToDTO(value)).orElse(null);
        }catch (Exception ex){
            return null;
        }
    }
}
