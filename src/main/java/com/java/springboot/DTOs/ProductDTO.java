package com.java.springboot.DTOs;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ProductDTO {

        private long id;

        @NotNull
        private long productCode;

        @Length(max = 100)
        @NotNull
        private String description;

        @NotNull
        private int price;

        @NotNull
        private int inventory;

        private List<Long> orderIds;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductCode() {
        return productCode;
    }

    public void setProductCode(long productCode) {
        this.productCode = productCode;
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

    public List<Long> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }
}
