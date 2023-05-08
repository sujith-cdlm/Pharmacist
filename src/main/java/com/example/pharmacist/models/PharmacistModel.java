package com.example.pharmacist.models;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "pharmacist_details")
public class PharmacistModel {

    @Id
    @GeneratedValue
    int id;
    String userName;
    String password;
    String fullName;
    String address;
    String designation;

    //@NotEmpty(message = "Email address cannot be blank")
    //@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid Email Address")
    String email;

    //@NonNull
    //@Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid Mobile Number")
    Long phoneNumber;

    public PharmacistModel() {
    }

    public PharmacistModel(int id, String userName, String password, String fullName, String address, String designation, String email, @NonNull Long phoneNumber) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.designation = designation;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NonNull Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
