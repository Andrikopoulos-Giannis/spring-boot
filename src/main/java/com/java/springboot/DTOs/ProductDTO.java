package com.java.springboot.DTOs;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ProductDTO {

        private long id;

        @NotNull
        private long product_code;

        @Length(max = 100)
        @NotNull
        private String description;

        @NotNull
        private int price;

        @NotNull
        private int inventory;

        private List<Long> orders_ids;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProduct_code() {
        return product_code;
    }

    public void setProduct_code(long product_code) {
        this.product_code = product_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public List<Long> getOrders_ids() {
        return orders_ids;
    }

    public void setOrders_ids(List<Long> orders_ids) {
        this.orders_ids = orders_ids;
    }
}
