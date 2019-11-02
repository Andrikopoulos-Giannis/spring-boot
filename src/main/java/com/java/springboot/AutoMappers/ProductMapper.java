package com.java.springboot.AutoMappers;

import com.java.springboot.DTOs.ProductDTO;
import com.java.springboot.Models.Order;
import com.java.springboot.Models.Product;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProductMapper {


     public Product DtoToProduct(ProductDTO productDTO){
         Product product = new Product();
         product.setProductCode(productDTO.getProductCode());
         product.setDescription(productDTO.getDescription());
         product.setPrice(productDTO.getPrice());
         product.setInventory(productDTO.getInventory());

         return product;
     }

     public ProductDTO ProductToDTO(Product product){
         ProductDTO productDTO = new ProductDTO();
         productDTO.setId(product.getId());
         productDTO.setDescription(product.getDescription());
         productDTO.setProductCode(product.getProductCode());
         productDTO.setPrice(product.getPrice());
         productDTO.setInventory(product.getInventory());
         productDTO.setOrders(product.getOrders().stream().map(Order::getId).collect(Collectors.toList()));

         return productDTO;
     }
}
