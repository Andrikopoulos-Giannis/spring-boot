package com.java.springboot.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java.springboot.Models.Order;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

public class CustomerDTO {

    private long id;

    @Length(max = 100)
    @NotEmpty
    private String name;

    @Length(max = 100)
    @NotEmpty
    private String surname;

    @Length(max = 100)
    @NotEmpty
    private String city;

    @NotEmpty
    @Positive
    private int zipCode;

    @Length(max = 100)
    @NotNull
    private String address;

    @NotEmpty
    @Positive
    private int addressNumber;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;

    @Length(max = 100)
    @NotEmpty
    private String email;

    private List<Long> orders;



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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getOrders() {
        return orders;
    }

    public void setOrders(List<Long> orders) {
        this.orders = orders;
    }
}
