package com.wipro.developmentprogram.ecommerceshopping.model;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_CHECKOUT") // gives an error when the table has the name "ORDER"
public class Order {

    @Id
    @SequenceGenerator(name = "order_number_gen", initialValue = 1001)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "order_number_gen")
    private Long orderNumber;
    @OneToOne
    private Checkout checkout;

    public Order(Checkout checkout) {
        this.checkout = checkout;
    }

    public Order() {
    }

    public Long getOrderNumber() {
        return this.orderNumber;
    }

    public Checkout getCheckout() {
        return this.checkout;
    }
}

