package com.java.springboot.Services;

import com.java.springboot.DTOs.CustomerDTO;
import com.java.springboot.JpaRepositories.CustomerRepository;
import com.java.springboot.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public void create(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setAddress(customerDTO.getAddress());
        customer.setAddress_number(customerDTO.getAddress_number());
        customer.setCity(customerDTO.getCity());
        customer.setDate_of_birth(customerDTO.getDate_of_birth());
        customer.setEmail(customerDTO.getEmail());
        customer.setZip_code(customerDTO.getZip_code());
        customerRepository.save(customer);
    }
}
