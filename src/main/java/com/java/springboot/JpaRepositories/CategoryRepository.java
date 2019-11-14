package com.java.springboot.JpaRepositories;

import com.java.springboot.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("FROM Category category WHERE category.name = :categoryName")
    Optional<Category> findByName(@Param("categoryName") String categoryName);

}
