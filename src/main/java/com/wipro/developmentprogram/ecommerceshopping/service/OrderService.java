package com.wipro.developmentprogram.ecommerceshopping.service;

import com.wipro.developmentprogram.ecommerceshopping.validations.ValidationUtils;
import com.wipro.developmentprogram.ecommerceshopping.dto.OrderDTO;
import com.wipro.developmentprogram.ecommerceshopping.model.Checkout;
import com.wipro.developmentprogram.ecommerceshopping.model.Order;
import com.wipro.developmentprogram.ecommerceshopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    private final OrderRepository repository;
    private ValidationUtils validationUtils = new ValidationUtils();

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order findById(Long orderNumber) {
        return repository.findById(orderNumber).orElse(null);
    }

    public List<Order> listAll() {
        return repository.findAllByOrderByOrderNumberAsc();
    }

    public Order create(OrderDTO orderDTO) {
        return verify(orderDTO.getCheckout())
                ? repository.save(
                new Order(orderDTO.getCheckout()))
                : null;
    }

    private boolean verify(Checkout checkout) {
        try {
            return validationUtils.isValidCart(checkout.getCart())
                    && validationUtils.isValidShippingInformation(checkout.getShippingInformation())
                    && validationUtils.isValidPaymentMethod(checkout.getPaymentMethod());
        } catch (UnknownError error) {
            System.out.println("Unexpected error occurred");
            return false;
        }
    }

}
