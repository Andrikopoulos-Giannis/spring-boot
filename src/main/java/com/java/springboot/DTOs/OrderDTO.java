package com.java.springboot.DTOs;

import com.java.springboot.Models.Customer;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.List;

public class OrderDTO {

    private long id;

    @NotNull
    private int quantity;

    @NotNull
    private float amount;

    @NotNull
    @Length(max = 100)
    private String alternative_address;

    @NotNull
    private int alternative_address_number;

    @NotNull
    private Long customer_id;

    @NotNull
    private Long product_id;

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

    public String getAlternative_address() {
        return alternative_address;
    }

    public void setAlternative_address(String alternative_address) {
        this.alternative_address = alternative_address;
    }

    public int getAlternative_address_number() {
        return alternative_address_number;
    }

    public void setAlternative_address_number(int alternative_address_number) {
        this.alternative_address_number = alternative_address_number;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
