package com.java.springboot.Services;

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

    @Transactional
    public String create(ProductDTO productDTO) {

        try{
            Optional<Product> prod = productRepository.findByProduct_code(productDTO.getProductCode());
            if (!prod.isPresent()){
                Product product = new Product();
                product.setDescription(productDTO.getDescription());
                product.setProductCode(productDTO.getProductCode());
                product.setPrice(productDTO.getPrice());
                product.setInventory(productDTO.getInventory());

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
}
