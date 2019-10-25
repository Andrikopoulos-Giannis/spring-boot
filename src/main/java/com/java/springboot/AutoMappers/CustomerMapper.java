package com.java.springboot.AutoMappers;

import com.java.springboot.DTOs.CustomerDTO;
import com.java.springboot.Models.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    private ModelMapper mapper = new ModelMapper();

    public CustomerMapper(){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        mapper.addMappings(new PropertyMap<CustomerDTO, Customer>() {
            @Override
            protected  void configure(){}
        });

        mapper.getTypeMap(CustomerDTO.class, Customer.class).setPostConverter(mappingContext ->{
            Customer customer = mappingContext.getDestination();
            //customer.
            return  customer;
        });
    }



}
