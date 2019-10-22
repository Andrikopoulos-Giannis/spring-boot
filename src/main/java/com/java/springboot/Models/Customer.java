package com.java.springboot.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME",nullable =false)
    @Length(max = 100)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    @Length(max = 100)
    private String surname;

    @Column(name = "CITY", nullable =false)
    @Length(max = 100)
    private String city;

    @Column(name = "ZIP_CODE", nullable =false)
    @Positive
    private int zip_code;

    @Column(name = "ADDRESS", nullable =false)
    @Length(max = 100)
    private String address;

    @Column(name = "ADDRESS_NUMBER", nullable =false)
    @Positive
    private int address_number;

    @Column(name = "BIRTH_DATE", nullable =false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date_of_birth;

    @Column(name = "EMAIL", nullable = false)
    @Length(max = 100)
    private String email;

    @OneToMany
    private List<Order> orders;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAddress_number() {
        return address_number;
    }

    public void setAddress_number(int address_number) {
        this.address_number = address_number;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
