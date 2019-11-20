package com.java.springboot.Services;

import com.java.springboot.DTOs.GenericResponceDTO;
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
    public GenericResponceDTO create(ProductDTO productDTO) {
        GenericResponceDTO responceDTO = new GenericResponceDTO();
        try{
            Optional<Product> prod = productRepository.findByProduct_code(productDTO.getProductCode());
            if (!prod.isPresent()){
                Optional<Category> category = categoryRepository.findById(productDTO.getCategory());
                if (category.isPresent()) {
                    Product product = productMapper.DtoToProduct(productDTO);
                    productRepository.save(product);
                    responceDTO.setMessage("Product saved Successfully!");
                    responceDTO.setObject(productDTO);
                    return responceDTO;
                }else{
                    responceDTO.setMessage("Category not exists");
                    return responceDTO;
                }
            }else
            {
                responceDTO.setMessage("Product already exists");
                return  responceDTO;
            }
        }catch (Exception ex){
            responceDTO.setMessage("Something went wrong");
            return responceDTO;
        }


    }

    @Transactional
    public ProductDTO getProductById(long productId){
        try{
            Product product = productRepository.findById(productId).get();
            ProductDTO productDTO = productMapper.ProductToDTO(product);

            return productDTO;
        }catch (Exception ex){
            return null;
        }

    }
}
