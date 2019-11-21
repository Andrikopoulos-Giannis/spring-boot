package com.java.springboot.Services;

import com.java.springboot.DTOs.GenericResponseDTO;
import com.java.springboot.JpaRepositories.CategoryRepository;
import com.java.springboot.Mappers.ProductMapper;
import com.java.springboot.DTOs.ProductDTO;
import com.java.springboot.JpaRepositories.ProductRepository;
import com.java.springboot.Models.Category;
import com.java.springboot.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public GenericResponseDTO create(ProductDTO productDTO) {
        GenericResponseDTO responseDTO = new GenericResponseDTO();
        try{
            Optional<Product> prod = productRepository.findByProduct_code(productDTO.getProductCode());
            if (!prod.isPresent()){
                Optional<Category> category = categoryRepository.findById(productDTO.getCategory());
                if (category.isPresent()) {
                    Product product = productMapper.DtoToProduct(productDTO);
                    productRepository.save(product);
                    responseDTO.setMessage("Product saved Successfully!");
                    responseDTO.setObject(productDTO);
                    return responseDTO;
                }else{
                    responseDTO.setMessage("Category not exists");
                    return responseDTO;
                }
            }else
            {
                responseDTO.setMessage("Product already exists");
                return  responseDTO;
            }
        }catch (Exception ex){
            responseDTO.setMessage("Something went wrong");
            return responseDTO;
        }


    }

    @Transactional
    public ProductDTO getProductById(long productId){
        try{
            Optional<Product> product = productRepository.findById(productId);
            return product.map(value -> productMapper.ProductToDTO(value)).orElse(null);
        }catch (Exception ex){
            return null;
        }

    }
}
