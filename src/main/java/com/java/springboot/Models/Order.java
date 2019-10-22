package com.java.springboot.Models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "QUANTITY", nullable = false)
    private int quantity;

    @Column(name = "AMOUNT", nullable = false)
    private float amount;

    @Column(name = "ALTERNATIVE_ADDRESS")
    @Length(max = 100)
    private String alternative_address;

    @Column(name = "ALTERNATIVE_ADDRESS_NUMBER")
    private int alternative_address_number;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<Product> products;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
