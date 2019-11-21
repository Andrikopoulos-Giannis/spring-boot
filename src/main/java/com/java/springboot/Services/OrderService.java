package com.java.springboot.Services;

import com.java.springboot.DTOs.GenericResponseDTO;
import com.java.springboot.Mappers.FullOrderMapper;
import com.java.springboot.Mappers.OrderMapper;
import com.java.springboot.DTOs.OrderDTO;
import com.java.springboot.DTOs.FullOrderDTO;
import com.java.springboot.JpaRepositories.CustomerRepository;
import com.java.springboot.JpaRepositories.OrderRepository;
import com.java.springboot.Models.Customer;
import com.java.springboot.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private FullOrderMapper fullOrderMapper;

    @Transactional
    public GenericResponseDTO create(OrderDTO orderDTO) {
        GenericResponseDTO responseDTO = new GenericResponseDTO();
        try {
            Optional<Customer> customer = customerRepository.findById(orderDTO.getCustomer());
            if (customer.isPresent()) {
                Order order = orderMapper.DtoToOrder(orderDTO);
                orderRepository.save(order);
                responseDTO.setMessage("Your Order created successfully!");
                responseDTO.setObject(orderDTO);
                return responseDTO;
            } else {
                responseDTO.setMessage("Customer not exists");
                return responseDTO;
            }
        } catch (Exception ex) {
            responseDTO.setMessage("Something went wrong");
            return responseDTO;
        }
    }

    @Transactional
    public OrderDTO getById(Long orderId){
        try {
            Optional<Order> order = orderRepository.findById(orderId);
            return order.map(value -> orderMapper.OrderToOrderDTO(value)).orElse(null);
        }catch (Exception ex){
            return  null;
        }

    }

    @Transactional
    public FullOrderDTO getFullOrderById(Long orderId){
        try {
            Optional<Order> order = orderRepository.findById(orderId);
            return order.map(value -> fullOrderMapper.orderToDto(value)).orElse(null);
        }catch (Exception ex){
            return null;
        }
    }

    @Transactional
    public List<FullOrderDTO> getOrdersByCustomerId(Long customerId){
        try {
            return fullOrderMapper.ordersListToFullOrdersDtoList(orderRepository.findAllByCustomerId(customerId));
        }catch (Exception ex){
            return null;
        }
    }

}
