package com.wipro.developmentprogram.ecommerceshopping.dto;

import com.wipro.developmentprogram.ecommerceshopping.model.Cart;
import com.wipro.developmentprogram.ecommerceshopping.model.ItemShopping;

import java.util.Set;

public class CartDTO {

    private Set<ItemShopping> itemsShopping;
    private int totalPrice;

    public CartDTO(Cart cart) {
        this.itemsShopping = cart.getItemsShopping();
        this.totalPrice = cart.getTotalPrice();
        this.totalPrice = getTotalPrice();
    }

    public CartDTO() {
    }

    public Cart dtoToEntity(CartDTO dto) {
        return new Cart(dto.getItemsShopping(),dto.getTotalPrice());
    }

    public CartDTO entityToDTO(Cart entity) {
        return new CartDTO(entity);
    }

    public Set<ItemShopping> getItemsShopping() {
        return itemsShopping;
    }

    public void setItemsShopping(Set<ItemShopping> itemsShopping) {
        this.itemsShopping = itemsShopping;
    }

    public int getTotalPrice() {
        return this.getItemsShopping().stream()
                .map(ItemShopping::getSubTotalPrice)
                .reduce(0, Integer::sum);
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
