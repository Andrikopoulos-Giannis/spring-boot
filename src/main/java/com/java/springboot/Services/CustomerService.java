package com.java.springboot.Services;

import com.java.springboot.DTOs.GenericResponceDTO;
import com.java.springboot.Mappers.CustomerMapper;
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

    @Autowired
    private CustomerMapper customerMapper;

    @Transactional
    public GenericResponceDTO create(CustomerDTO customerDTO) {
        GenericResponceDTO responceDTO = new GenericResponceDTO();
        try {
            Optional<Customer> cust = customerRepository.findByEmail(customerDTO.getEmail());
            if (!cust.isPresent()){

                Customer customer = customerMapper.DtoToCustomer(customerDTO);
                customerRepository.save(customer);

                responceDTO.setMessage("Customer saved successfully!");
                responceDTO.setObject(customerDTO);

                return responceDTO;
            }else
            {
                responceDTO.setMessage("Customer already exists");

                return responceDTO;
            }
        }catch (Exception ex){
            responceDTO.setMessage("Something went wrong");
            return responceDTO;
        }

    }

    @Transactional
    public CustomerDTO getById(Long customerId){

        try {
            Customer customer = customerRepository.findById(customerId).get();
            CustomerDTO customerDTO = customerMapper.customerToDTO(customer);
            return customerDTO;
        }catch (Exception ex){
            return null;
        }
    }
}
