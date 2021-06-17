package com.wipro.developmentprogram.ecommerceshopping.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Checkout extends BaseEntity {

    @Embedded
    private Cart cart;
    @OneToOne
    private ShippingInformation shippingInformation;
    @OneToOne
    private PaymentMethod paymentMethod;

    public Checkout(Cart cart, ShippingInformation shippingInformation, PaymentMethod paymentMethod) {
        this.cart = cart;
        this.shippingInformation = shippingInformation;
        this.paymentMethod = paymentMethod;
    }

    public Checkout() {
    }

    public Cart getCart() {
        return this.cart;
    }

    public ShippingInformation getShippingInformation() {
        return this.shippingInformation;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

}
