package com.java.springboot.Services;

import com.java.springboot.DTOs.ProductDTO;
import com.java.springboot.JpaRepositories.ProductRepository;
import com.java.springboot.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void create(ProductDTO productDTO) {

        Product product = new Product();
        product.setDescription(productDTO.getDescription());
        product.setProduct_code(productDTO.getProduct_code());
        product.setPrice(productDTO.getPrice());
        product.setInventory(productDTO.getInventory());

        productRepository.save(product);
    }
}
