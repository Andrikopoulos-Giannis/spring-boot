package com.java.springboot.Services;

import com.java.springboot.DTOs.GenericResponseDTO;
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
    public GenericResponseDTO create(CustomerDTO customerDTO) {
        GenericResponseDTO responseDTO = new GenericResponseDTO();
        try {
            Optional<Customer> cust = customerRepository.findByEmail(customerDTO.getEmail());
            if (!cust.isPresent()){

                Customer customer = customerMapper.DtoToCustomer(customerDTO);
                customerRepository.save(customer);

                responseDTO.setMessage("Customer saved successfully!");
                responseDTO.setObject(customerDTO);

                return responseDTO;
            }else
            {
                responseDTO.setMessage("Customer already exists");

                return responseDTO;
            }
        }catch (Exception ex){
            responseDTO.setMessage("Something went wrong");
            return responseDTO;
        }

    }

    @Transactional
    public CustomerDTO getById(Long customerId){

        try {
            Optional<Customer> customer = customerRepository.findById(customerId);
            return customer.map(value -> customerMapper.customerToDTO(value)).orElse(null);
        }catch (Exception ex){
            return null;
        }
    }
}
