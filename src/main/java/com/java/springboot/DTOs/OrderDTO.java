package com.java.springboot.DTOs;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class OrderDTO {

    private long id;

    @Positive
    private int quantity;

    @NotNull
    private float amount;

    @Length(max = 100)
    private String alternativeAddress;

    private int alternativeAddressNumber;

    @NotNull
    private Long customer;

    @NotNull
    private Long product;

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

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public Long getProduct() {
        return product;
    }

    public void setProductId(Long product) {
        this.product = product;
    }
}
