package com.wipro.developmentprogram.ecommerceshopping.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Embeddable
public class Cart{

    @Embedded
    private Set<ItemShopping> itemsShopping = new HashSet<>();
    private int totalPrice;

    public Cart(Set<ItemShopping> itemsShopping, int totalPrice) {
        this.itemsShopping = itemsShopping;
        this.totalPrice = totalPrice;
    }

    public Cart() {
    }

    public Set<ItemShopping> getItemsShopping() {
        return itemsShopping;
    }

    //    public Set<ItemShopping> getItemsShopping() {
//        return itemsShopping.stream()
//                .sorted(Comparator.comparing(itemShopping -> itemShopping.getItem().getSKUId()))
//                .collect(Collectors.toCollection(LinkedHashSet::new));
//    }

    public int getTotalPrice() {
        return itemsShopping.stream()
                .map(ItemShopping::getSubTotalPrice)
                .reduce(0, Integer::sum);
    }
}
