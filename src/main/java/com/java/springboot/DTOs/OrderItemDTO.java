package com.java.springboot.DTOs;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class OrderItemDTO {

    private  Long id;

    @Positive
    private int quantity;

    private float amount;

    @NotNull
    private Long product;

    private Long order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }
}
