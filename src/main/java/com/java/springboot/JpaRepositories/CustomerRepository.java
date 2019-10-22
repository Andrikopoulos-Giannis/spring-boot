package com.java.springboot.JpaRepositories;

import com.java.springboot.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Override
    default Optional<Customer> findById(Long aLong) {
        return Optional.empty();
    }
}
