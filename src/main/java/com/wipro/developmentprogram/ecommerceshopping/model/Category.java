package com.wipro.developmentprogram.ecommerceshopping.model;

import javax.persistence.Embeddable;

@Embeddable
public class Category{

    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }
}
