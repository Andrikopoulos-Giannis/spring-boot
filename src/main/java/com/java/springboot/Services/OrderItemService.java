package com.java.springboot.Services;

import com.java.springboot.DTOs.OrderItemDTO;
import com.java.springboot.JpaRepositories.OrderItemRepository;
import com.java.springboot.JpaRepositories.ProductRepository;
import com.java.springboot.Mappers.OrderItemMapper;
import com.java.springboot.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Transactional
    public String create(OrderItemDTO orderItemDTO){
        //try {
            Optional<Product> product = productRepository.findById(orderItemDTO.getProduct());
            if (product.isPresent()){
                if (product.get().getInventory()>= orderItemDTO.getQuantity()){
                    orderItemMapper.orderItemToDto(orderItemRepository.save(orderItemMapper.DtoToOrderItem(orderItemDTO)));
                    productRepository.updateInventory((product.get().getInventory() - orderItemDTO.getQuantity()), orderItemDTO.getProduct());
                    return "OrderItem saved Successfully!";
                }else{
                    return "Quantity of product is greater than inventory";
                }
            }else{
                return "Product not exists";
            }
        //}catch (Exception ex){
          //  return "something went wrong";
        //}
    }

    @Transactional
    public OrderItemDTO getOrderItemById(Long orderItemId){
        try {
            OrderItemDTO orderItemDTO = orderItemMapper.orderItemToDto(orderItemRepository.findById(orderItemId).get());
            return orderItemDTO;
        }catch (Exception ex){
            return null;
        }
    }
}
