package com.java.springboot.Mappers;

import com.java.springboot.DTOs.OrderItemDTO;
import com.java.springboot.JpaRepositories.OrderRepository;
import com.java.springboot.JpaRepositories.ProductRepository;
import com.java.springboot.Models.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public OrderItemDTO orderItemToDto(OrderItem orderItem){
        OrderItemDTO orderItemDTO = new OrderItemDTO();

        orderItemDTO.setId(orderItem.getId());
        orderItemDTO.setAmount(orderItem.getAmount());
        orderItemDTO.setQuantity(orderItem.getQuantity());
        orderItemDTO.setOrder(orderItem.getOrder().getId());
        orderItemDTO.setProduct(orderItem.getProduct().getId());

        return orderItemDTO;
    }

    public OrderItem DtoToOrderItem(OrderItemDTO orderItemDTO){
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDTO.getId());
        orderItem.setAmount(orderItemDTO.getAmount());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setOrder(orderRepository.findById(orderItemDTO.getOrder()).get());
        orderItem.setProduct(productRepository.findById(orderItemDTO.getProduct()).get());

        return orderItem;
    }
}
