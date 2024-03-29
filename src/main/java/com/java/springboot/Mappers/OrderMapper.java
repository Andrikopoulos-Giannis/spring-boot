package com.java.springboot.Mappers;

import com.java.springboot.DTOs.OrderDTO;
import com.java.springboot.JpaRepositories.CustomerRepository;
import com.java.springboot.Models.Order;
import com.java.springboot.Models.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    private CustomerRepository customerRepository;

    public Order DtoToOrder(OrderDTO orderDTO){
        Order order = new Order();
        order.setAlternativeAddressNumber(orderDTO.getAlternativeAddressNumber());
        order.setAlternativeAddress(orderDTO.getAlternativeAddress());
        order.setAmount(orderDTO.getAmount());
        order.setCustomer(customerRepository.findById(orderDTO.getCustomer()).get());

        return order;
    }

    public OrderDTO OrderToOrderDTO(Order order){

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setAlternativeAddress(order.getAlternativeAddress());
        orderDTO.setAlternativeAddressNumber(order.getAlternativeAddressNumber());
        orderDTO.setAmount(order.getAmount());
        orderDTO.setCustomer(order.getCustomer().getId());
        orderDTO.setOrderItems(order.getOrderItems().stream().map(OrderItem::getId).collect(Collectors.toList()));

        return orderDTO;
    }

}
