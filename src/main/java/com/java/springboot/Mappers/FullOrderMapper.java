package com.java.springboot.Mappers;


import com.java.springboot.DTOs.FullOrderDTO;
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
    private ProductMapper productMapper;

    public FullOrderDTO orderToDto(Order order){
        FullOrderDTO fullOrderDTO = new FullOrderDTO();
        fullOrderDTO.setId(order.getId());
        fullOrderDTO.setAlternativeAddress(order.getAlternativeAddress());
        fullOrderDTO.setAlternativeAddressNumber(order.getAlternativeAddressNumber());
        fullOrderDTO.setAmount(order.getAmount());
        fullOrderDTO.setQuantity(order.getQuantity());
        fullOrderDTO.setCustomer(customerMapper.customerToDTO(order.getCustomer()));
        fullOrderDTO.setProduct(productMapper.ProductToDTO(order.getProduct()));

        return  fullOrderDTO;
    }

    public List<FullOrderDTO> ordersListToFullOrdersDtoList(List<Order> orders){
        List<FullOrderDTO> ordersList = new ArrayList<>();
        orders.forEach(order -> ordersList.add(orderToDto(order)));

        return ordersList;
    }
}
