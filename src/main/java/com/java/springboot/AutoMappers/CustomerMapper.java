package com.java.springboot.AutoMappers;

import com.java.springboot.DTOs.CustomerDTO;
import com.java.springboot.Models.Customer;
import com.java.springboot.Models.Order;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    private ModelMapper mapper = new ModelMapper();

    public CustomerMapper(){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        mapper.addMappings(new PropertyMap<CustomerDTO, Customer>() {
            @Override
            protected  void configure() {
                map().setName(source.getName());
                map().setSurname(source.getSurname());
                map().setZipCode(source.getZipCode());
                map().setDateOfBirth(source.getDateOfBirth());
                map().setAddress(source.getAddress());
                map().setAddressNumber(source.getAddressNumber());
                map().setCity(source.getCity());
                map().setEmail(source.getEmail());
            }
        });

        mapper.addMappings(new PropertyMap<Customer, CustomerDTO>() {
            @Override
            protected void configure(){
                map().setName(source.getName());
                map().setSurname(source.getSurname());
                map().setZipCode(source.getZipCode());
                map().setDateOfBirth(source.getDateOfBirth());
                map().setAddress(source.getAddress());
                map().setAddressNumber(source.getAddressNumber());
                map().setCity(source.getCity());
                map().setEmail(source.getEmail());
                map().setOrders(source.getOrders().stream().map(Order::getId).collect(Collectors.toList()));
            }
        });

    }

}
