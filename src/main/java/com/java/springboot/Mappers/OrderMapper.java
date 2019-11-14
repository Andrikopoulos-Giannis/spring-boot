package com.java.springboot.Mappers;

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
        order.setAmount(productRepository.findById(orderDTO.getProduct()).get().getPrice() * orderDTO.getQuantity());
        order.setQuantity(orderDTO.getQuantity());
        order.setCustomer(customerRepository.findById(orderDTO.getCustomer()).get());
        order.setProduct(productRepository.findById(orderDTO.getProduct()).get());

        return order;
    }

    public OrderDTO OrderToOrderDTO(Order order){

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setQuantity(order.getQuantity());
        orderDTO.setAlternativeAddress(order.getAlternativeAddress());
        orderDTO.setAlternativeAddressNumber(order.getAlternativeAddressNumber());
        orderDTO.setAmount(order.getAmount());
        orderDTO.setCustomer(order.getCustomer().getId());
        orderDTO.setProductId(order.getProduct().getId());

        return orderDTO;
    }

}
