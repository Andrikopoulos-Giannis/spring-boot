package com.java.springboot.Services;

import com.java.springboot.DTOs.OrderItemDTO;
import com.java.springboot.JpaRepositories.OrderItemRepository;
import com.java.springboot.JpaRepositories.OrderRepository;
import com.java.springboot.JpaRepositories.ProductRepository;
import com.java.springboot.Mappers.OrderItemMapper;
import com.java.springboot.Models.Order;
import com.java.springboot.Models.OrderItem;
import com.java.springboot.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public String create(OrderItemDTO orderItemDTO){
        try {
            Optional<Product> product = productRepository.findById(orderItemDTO.getProduct());
            Optional<Order> order = orderRepository.findById(orderItemDTO.getOrder());

            if (order.isPresent()){
                if (product.isPresent()){
                    if (product.get().getInventory()>= orderItemDTO.getQuantity()){
                        orderItemDTO.setAmount(orderItemDTO.getQuantity() * product.get().getPrice());
                        orderItemRepository.save(orderItemMapper.DtoToOrderItem(orderItemDTO));
                        productRepository.updateInventory((product.get().getInventory() - orderItemDTO.getQuantity()), orderItemDTO.getProduct());
                        float amount = order.get().getAmount() + orderItemDTO.getAmount();
                        orderRepository.updateAmount(amount, orderItemDTO.getOrder());
                        return "OrderItem saved Successfully!";
                    }else{
                        return "Quantity of product is greater than inventory";
                    }
                }else{
                    return "Product not exists";
                }
            }else{
                return "order not exists";
            }

        }catch (Exception ex){
            return "something went wrong";
        }
    }

    @Transactional
    public OrderItemDTO getOrderItemById(Long orderItemId){
        try {
            OrderItemDTO orderItemDTO = orderItemMapper.orderItemToDto(orderItemRepository.findById(orderItemId).get());
            return orderItemDTO;
        }catch (Exception ex){
            return null;
        }
    }
}
