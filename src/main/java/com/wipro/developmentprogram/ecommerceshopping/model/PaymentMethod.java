package com.wipro.developmentprogram.ecommerceshopping.model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PaymentMethod extends BaseEntity {

    private String cardNumber;
    private LocalDate expiryDate;
    private int cvv;

    public PaymentMethod(String cardNumber, LocalDate expiryDate, int cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public PaymentMethod() {
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    public int getCvv() {
        return this.cvv;
    }
}
