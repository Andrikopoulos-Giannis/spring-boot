package com.java.springboot.Services;

import com.java.springboot.DTOs.CustomerDTO;
import com.java.springboot.JpaRepositories.CustomerRepository;
import com.java.springboot.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public String create(CustomerDTO customerDTO){
        try {
            Optional<Customer> cust = customerRepository.findByEmail(customerDTO.getEmail());
            if (!cust.isPresent()){
                Customer customer = new Customer();
                customer.setName(customerDTO.getName());
                customer.setSurname(customerDTO.getSurname());
                customer.setAddress(customerDTO.getAddress());
                customer.setAddressNumber(customerDTO.getAddressNumber());
                customer.setCity(customerDTO.getCity());
                customer.setDateOfBirth(customerDTO.getDateOfBirth());
                customer.setEmail(customerDTO.getEmail());
                customer.setZipCode(customerDTO.getZipCode());
                customerRepository.save(customer);
                return "Customer saved successfully!";
            }else
            {
                return "Customer already exists.";
            }
        }catch (Exception ex){
            return "Something went wrong:" + ex.toString();
        }

    }
}
