package com.java.springboot.DTOs;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CategoryDTO {

    private Long id;

    @NotEmpty
    @Length(max = 100)
    private String name;

    private Long parentCategory;

    private List<Long> subCategories;

    private List<Long> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Long parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Long> getProducts() {
        return products;
    }

    public void setProducts(List<Long> products) {
        this.products = products;
    }

    public List<Long> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Long> subCategories) {
        this.subCategories = subCategories;
    }
}
