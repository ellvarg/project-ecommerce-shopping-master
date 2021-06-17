package com.wipro.developmentprogram.ecommerceshopping.dto;

import com.wipro.developmentprogram.ecommerceshopping.model.Checkout;

public class CheckoutDTO {

    private CartDTO cart;
    private ShippingInformationDTO shippingInformation;
    private PaymentMethodDTO paymentMethod;

    public CheckoutDTO(Checkout checkout) {
        this.cart = new CartDTO(checkout.getCart());
        this.shippingInformation = new ShippingInformationDTO(checkout.getShippingInformation());
        this.paymentMethod = new PaymentMethodDTO(checkout.getPaymentMethod());
    }

    public CheckoutDTO entityToDTO(Checkout entity) {
        return new CheckoutDTO(entity);
    }

    public Checkout dtoToEntity(CheckoutDTO dto) {
        return new Checkout(cart.dtoToEntity(dto.getCart()),
                shippingInformation.dtoToEntity(dto.getShippingInformation()),
                paymentMethod.dtoToEntity(dto.getPaymentMethod()));
    }

    public CartDTO getCart() {
        return cart;
    }

    public void setCart(CartDTO cart) {
        this.cart = cart;
    }

    public ShippingInformationDTO getShippingInformation() {
        return shippingInformation;
    }

    public void setShippingInformation(ShippingInformationDTO shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    public PaymentMethodDTO getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodDTO paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
