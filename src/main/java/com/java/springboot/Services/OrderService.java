package com.java.springboot.Services;

import com.java.springboot.AutoMappers.FullOrderMapper;
import com.java.springboot.AutoMappers.OrderMapper;
import com.java.springboot.DTOs.OrderDTO;
import com.java.springboot.DTOs.FullOrderDTO;
import com.java.springboot.JpaRepositories.CustomerRepository;
import com.java.springboot.JpaRepositories.OrderRepository;
import com.java.springboot.JpaRepositories.ProductRepository;
import com.java.springboot.Models.Customer;
import com.java.springboot.Models.Order;
import com.java.springboot.Models.Product;
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
    private ProductRepository productRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private FullOrderMapper fullOrderMapper;

    @Transactional
    public String create(OrderDTO orderDTO) {
        try {
            Optional<Customer> customer = customerRepository.findById(orderDTO.getCustomerId());
            if (customer.isPresent()) {
                Optional<Product> product = productRepository.findById(orderDTO.getProductId());
                if (product.isPresent()) {
                    if (product.get().getInventory()>= orderDTO.getQuantity()){
                        Order order = orderMapper.DtoToOrder(orderDTO);
                        orderRepository.save(order);
                        productRepository.updateInventory((product.get().getInventory() - orderDTO.getQuantity()), product.get().getId());//Update product
                        return "Your Order created successfully!";
                    }else{
                        return "Order quantity is greater than product inventory.";
                    }
                } else {
                    return "Product not exists.";
                }

            } else {
                return "Customer not exists.";
            }
        } catch (Exception ex) {
            return "Something went wrong:" + ex.toString();

        }
    }

    @Transactional
    public OrderDTO getById(Long orderId){
        try {
            Order order = orderRepository.findById(orderId).get();
            OrderDTO orderDTO = orderMapper.OrderToOrderDTO(order);
            return orderDTO;
        }catch (Exception ex){
            return  null;
        }

    }

    @Transactional
    public FullOrderDTO getFullOrderById(Long orderId){
        try {
            Order order = orderRepository.findById(orderId).get();
            FullOrderDTO fullOrderDTO = fullOrderMapper.orderToDto(order);
            return fullOrderDTO;
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
