package com.java.springboot.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;

public class CustomerDTO implements Serializable {

    private long id;

    @Length(max = 100)
    @NotNull
    private String name;

    @Length(max = 100)
    @NotNull
    private String surname;

    @Length(max = 100)
    @NotNull
    private String city;

    @NotNull
    @Positive
    private int zip_code;


    @Length(max = 100)
    @NotNull
    private String address;

    @NotNull
    @Positive
    private int address_number;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date_of_birth;

    @Length(max = 100)
    @NotNull
    private String email;

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
}
