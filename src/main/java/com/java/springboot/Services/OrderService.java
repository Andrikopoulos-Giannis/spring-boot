package com.java.springboot.Services;

import com.java.springboot.DTOs.OrderDTO;
import com.java.springboot.JpaRepositories.CustomerRepository;
import com.java.springboot.JpaRepositories.OrderRepository;
import com.java.springboot.JpaRepositories.ProductRepository;
import com.java.springboot.Models.Order;
import com.java.springboot.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public String create(OrderDTO orderDTO) {
        try {
            if (customerRepository.findById(orderDTO.getId()) != null) {

                if (productRepository.findById(orderDTO.getId()) != null) {
                    Order order = new Order();
                    order.setAlternative_address(orderDTO.getAlternative_address());
                    order.setAlternative_address_number(orderDTO.getAlternative_address_number());
                    Product product = productRepository.findById(orderDTO.getProduct_id()).get();
                    order.setProduct(product);
                    order.setQuantity(orderDTO.getQuantity());
                    order.setAmount(product.getPrice() * orderDTO.getQuantity());
                    order.setCustomer(customerRepository.findById(orderDTO.getCustomer_id()).get());
                    orderRepository.save(order);
                    return "Your Order created successfully!";
                } else {
                    return "Product not exists";
                }

            } else {
                return "Customer not exists";
            }
        } catch (Exception ex) {
            //throw new UnsupportedOperationException("We don't do this.");
            return "Something went wrong:" + ex.toString();

        }
    }


}
