package com.java.springboot.JpaRepositories;

import com.java.springboot.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("FROM Product product WHERE product.productCode LIKE :productCode")
    Optional<Product> findByProduct_code(@Param("productCode") Long productCode);
}

