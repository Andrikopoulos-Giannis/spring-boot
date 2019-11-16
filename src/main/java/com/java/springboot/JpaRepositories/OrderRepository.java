package com.java.springboot.JpaRepositories;

import com.java.springboot.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("FROM Order order WHERE order.customer.id = :customerId")
    List<Order> findAllByCustomerId(@Param("customerId") Long customerId);

    @Modifying
    @Query("UPDATE Order orders SET orders.amount = :amount WHERE orders.id = :orderId")
    void updateAmount(@Param("amount") float amount, @Param("orderId") long orderId);

}
