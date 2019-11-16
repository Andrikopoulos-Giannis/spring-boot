package com.java.springboot.DTOs;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

public class OrderDTO {

    private long id;

    @NotNull
    private float amount;

    @Length(max = 100)
    private String alternativeAddress;

    private int alternativeAddressNumber;

    @NotNull
    private Long customer;

    private List<Long> orderItems;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Long> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Long> orderItems) {
        this.orderItems = orderItems;
    }
}
