package com.java.springboot.Models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "AMOUNT")
    private float amount;

    @Column(name = "ALTERNATIVE_ADDRESS")
    @Length(max = 100)
    private String alternativeAddress;

    @Column(name = "ALTERNATIVE_ADDRESS_NUMBER")
    private int alternativeAddressNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    @Column(name = "ORDER_ITEMS")
    private List<OrderItem> orderItems;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
