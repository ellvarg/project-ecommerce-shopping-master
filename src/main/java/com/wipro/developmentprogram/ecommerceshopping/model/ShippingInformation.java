package com.wipro.developmentprogram.ecommerceshopping.model;

import javax.persistence.Entity;

@Entity
public class ShippingInformation extends BaseEntity {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;

    public ShippingInformation(String firstName, String lastName, String phone, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public ShippingInformation() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.address;
    }
}
