package com.java.springboot.Services;

import com.java.springboot.AutoMappers.ProductMapper;
import com.java.springboot.DTOs.ProductDTO;
import com.java.springboot.JpaRepositories.ProductRepository;
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

    @Transactional
    public String create(ProductDTO productDTO) {

        try{
            Optional<Product> prod = productRepository.findByProduct_code(productDTO.getProductCode());
            if (!prod.isPresent()){
                Product product = productMapper.DtoToProduct(productDTO);
                productRepository.save(product);
                return  "Product saved Successfully!";
            }else
            {
                return  "Product already exists.";
            }
        }catch (Exception ex){
            return "Something went wrong:" + ex.toString();
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
