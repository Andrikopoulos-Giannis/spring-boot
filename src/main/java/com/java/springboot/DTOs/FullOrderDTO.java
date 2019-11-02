package com.java.springboot.DTOs;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class FullOrderDTO {

    private long id;

    @Positive
    private int quantity;

    @NotNull
    private float amount;

    @Length(max = 100)
    private String alternativeAddress;

    private int alternativeAddressNumber;

    @NotEmpty
    private CustomerDTO customer;

    @NotEmpty
    private ProductDTO product;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getAlternativeAddress() {
        return alternativeAddress;
    }

    public void setAlternativeAddress(String alternativeAddress) {
        this.alternativeAddress = alternativeAddress;
    }

    public int getAlternativeAddressNumber() {
        return alternativeAddressNumber;
    }

    public void setAlternativeAddressNumber(int alternativeAddressNumber) {
        this.alternativeAddressNumber = alternativeAddressNumber;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
