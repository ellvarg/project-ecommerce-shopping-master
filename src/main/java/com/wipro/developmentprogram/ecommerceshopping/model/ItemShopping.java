package com.wipro.developmentprogram.ecommerceshopping.model;

import com.wipro.developmentprogram.ecommerceshopping.validations.ValidationUtils;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Embeddable
public class ItemShopping {

    @OneToOne
    private Item item;
    private int quantity;
    private int subTotalPrice;

    public ItemShopping(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.subTotalPrice = getSubTotalPrice();
    }

    public ItemShopping() {
    }

    public Item getItem() {
        return this.item;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getSubTotalPrice() {
        return this.item.getPrice() * this.quantity;
    }

}
