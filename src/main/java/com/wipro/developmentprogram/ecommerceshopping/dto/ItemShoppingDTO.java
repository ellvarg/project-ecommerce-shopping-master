package com.wipro.developmentprogram.ecommerceshopping.dto;

import com.wipro.developmentprogram.ecommerceshopping.model.Item;
import com.wipro.developmentprogram.ecommerceshopping.model.ItemShopping;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class ItemShoppingDTO {

    @Valid
    private ItemDTO item;
    @DecimalMin(value = "1", message = "Please enter valid input")
    @DecimalMax(value = "100000", message = "Please enter valid input")
    private int quantity;
    private int subTotalPrice;

    public ItemShoppingDTO(ItemShopping itemShopping) {
        this.item = new ItemDTO(itemShopping.getItem());
        this.quantity = itemShopping.getQuantity();
        this.subTotalPrice = getSubTotalPrice();
    }

    public ItemShoppingDTO(ItemDTO item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.subTotalPrice = getSubTotalPrice();
    }

    public ItemShoppingDTO() {
    }

    public ItemShoppingDTO entityToDTO(ItemShopping entity) {
        return new ItemShoppingDTO(entity);
    }

    public ItemShopping dtoToEntity(ItemShoppingDTO dto) {
        return new ItemShopping(item.dtoToEntity(dto.getItem()), dto.getQuantity());
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSubTotalPrice() {
        return item.getPrice() * quantity;
    }

    public void setSubTotalPrice(int subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }
}
