package com.java.springboot.Models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private String alternativeAddress;

    @Column(name = "ALTERNATIVE_ADDRESS_NUMBER")
    private int alternativeAddressNumber;

    @ManyToOne
    @NotNull
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Product product;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
