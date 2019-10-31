package com.java.springboot.AutoMappers;

import com.java.springboot.DTOs.OrderDTO;
import com.java.springboot.JpaRepositories.CustomerRepository;
import com.java.springboot.JpaRepositories.ProductRepository;
import com.java.springboot.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order DtoToOrder(OrderDTO orderDTO){
        Order order = new Order();
        order.setAlternativeAddressNumber(orderDTO.getAlternativeAddressNumber());
        order.setAlternativeAddress(orderDTO.getAlternativeAddress());
        order.setAmount(productRepository.findById(orderDTO.getProductId()).get().getPrice() * orderDTO.getQuantity());
        order.setQuantity(orderDTO.getQuantity());
        order.setCustomer(customerRepository.findById(orderDTO.getCustomerId()).get());
        order.setProduct(productRepository.findById(orderDTO.getProductId()).get());

        return order;
    }

    public OrderDTO OrderToOrderDTO(Order order){

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setQuantity(order.getQuantity());
        orderDTO.setAlternativeAddress(order.getAlternativeAddress());
        orderDTO.setAlternativeAddressNumber(order.getAlternativeAddressNumber());
        orderDTO.setAmount(order.getAmount());
        orderDTO.setCustomerId(order.getCustomer().getId());
        orderDTO.setProductId(order.getProduct().getId());

        return orderDTO;
    }
}
