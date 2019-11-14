package com.java.springboot.Mappers;

import com.java.springboot.DTOs.CustomerDTO;
import com.java.springboot.Models.Customer;
import com.java.springboot.Models.Order;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Customer DtoToCustomer(CustomerDTO customerDTO){

        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setZipCode(customerDTO.getZipCode());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());
        customer.setAddress(customerDTO.getAddress());
        customer.setAddressNumber(customerDTO.getAddressNumber());
        customer.setCity(customerDTO.getCity());
        customer.setEmail(customerDTO.getEmail());

        return  customer;
    }

   public CustomerDTO customerToDTO(Customer customer){

       CustomerDTO customerDTO = new CustomerDTO();
       customerDTO.setId(customer.getId());
       customerDTO.setName(customer.getName());
       customerDTO.setSurname(customer.getSurname());
       customerDTO.setZipCode(customer.getZipCode());
       customerDTO.setDateOfBirth(customer.getDateOfBirth());
       customerDTO.setAddress(customer.getAddress());
       customerDTO.setAddressNumber(customer.getAddressNumber());
       customerDTO.setCity(customer.getCity());
       customerDTO.setEmail(customer.getEmail());
       customerDTO.setOrders(customer.getOrders().stream().map(Order::getId).collect(Collectors.toList()));

       return  customerDTO;
    }


}
