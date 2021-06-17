package com.wipro.developmentprogram.ecommerceshopping.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Report extends BaseEntity {

    @OneToMany
    private Set<Order> orders;

    public Report(Set<Order> orders) {
        this.orders = orders;
    }

    public Report() {
    }

    public Set<Order> getOrders() {
        return this.orders;
    }
}

