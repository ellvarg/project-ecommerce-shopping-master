package com.wipro.developmentprogram.ecommerceshopping.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    private String SKUId;
    @Embedded
    private Category category;
    private String title;
    private String description;
    private int price;

    public Item(Category category, String title, String SKUId, String description, int price) {
        this.category = category;
        this.title = title;
        this.SKUId = SKUId;
        this.description = description;
        this.price = price;
    }

    private Item(String SKUId, Category category, String title, String description, int price) {
        this.SKUId = SKUId;
        this.category = category;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Item() {
    }

    public static Item update(String SKUId, Category category, String title, String description, int price) {
        return new Item(SKUId, category, title, description, price);
    }

    public Category getCategory() {
        return this.category;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSKUId() {
        return this.SKUId;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrice() {
        return this.price;
    }
}
