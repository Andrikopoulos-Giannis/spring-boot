package com.java.springboot.JpaRepositories;

import com.java.springboot.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("FROM Customer customer WHERE customer.email LIKE :email%")
    Optional<Customer> findByEmail(@Param("email") String email);
}
