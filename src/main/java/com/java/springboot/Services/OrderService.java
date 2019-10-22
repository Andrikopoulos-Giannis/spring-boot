package com.java.springboot.Services;

import com.java.springboot.DTOs.OrderDTO;
import com.java.springboot.JpaRepositories.CustomerRepository;
import com.java.springboot.JpaRepositories.OrderRepository;
import com.java.springboot.JpaRepositories.ProductRepository;
import com.java.springboot.Models.Customer;
import com.java.springboot.Models.Order;
import com.java.springboot.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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
            Optional<Customer> customer = customerRepository.findById(orderDTO.getCustomerId());
            if (customer.isPresent()) {
                Optional<Product> product = productRepository.findById(orderDTO.getProductId());
                if (product.isPresent()) {
                    if (product.get().getInventory()>= orderDTO.getQuantity()){
                        Order order = new Order();
                        order.setAlternativeAddress(orderDTO.getAlternativeAddress());
                        order.setAlternativeAddressNumber(orderDTO.getAlternativeAddressNumber());
                        order.setProduct(product.get());
                        order.setQuantity(orderDTO.getQuantity());
                        order.setAmount(product.get().getPrice() * orderDTO.getQuantity());
                        order.setCustomer(customer.get());
                        orderRepository.save(order);
                        //TODO: Update Product inventory
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


}
