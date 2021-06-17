package com.wipro.developmentprogram.ecommerceshopping.dto;

import com.wipro.developmentprogram.ecommerceshopping.model.Checkout;
import com.wipro.developmentprogram.ecommerceshopping.model.Order;

import javax.validation.constraints.NotNull;

public class OrderDTO {

    private Long orderNumber;

    @NotNull
    private Checkout checkout;

    public OrderDTO(Order order) {
        this.orderNumber = order.getOrderNumber();
        this.checkout = order.getCheckout();
    }

    public OrderDTO() {

    }

    public OrderDTO entityToDTO(Order entity){
        return new OrderDTO(entity);
    }

    public Order dtoToEntity(OrderDTO dto){
        return new Order(dto.getCheckout());
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }
}
