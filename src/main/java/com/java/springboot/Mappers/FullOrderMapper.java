package com.java.springboot.Mappers;


import com.java.springboot.DTOs.FullOrderDTO;
import com.java.springboot.DTOs.OrderItemDTO;
import com.java.springboot.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FullOrderMapper {


    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    public FullOrderDTO orderToDto(Order order){
        FullOrderDTO fullOrderDTO = new FullOrderDTO();
        fullOrderDTO.setId(order.getId());
        fullOrderDTO.setAlternativeAddress(order.getAlternativeAddress());
        fullOrderDTO.setAlternativeAddressNumber(order.getAlternativeAddressNumber());
        fullOrderDTO.setAmount(order.getAmount());
        fullOrderDTO.setCustomer(customerMapper.customerToDTO(order.getCustomer()));
        List<OrderItemDTO> orderItems = new ArrayList<>();
        order.getOrderItems().forEach(orderItem -> orderItems.add(orderItemMapper.orderItemToDto(orderItem)));
        fullOrderDTO.setOrderItems(orderItems);

        return  fullOrderDTO;
    }

    public List<FullOrderDTO> ordersListToFullOrdersDtoList(List<Order> orders){
        List<FullOrderDTO> ordersList = new ArrayList<>();
        orders.forEach(order -> ordersList.add(orderToDto(order)));

        return ordersList;
    }
}
