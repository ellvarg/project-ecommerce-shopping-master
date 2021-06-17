package com.wipro.developmentprogram.ecommerceshopping.controller;


import com.wipro.developmentprogram.ecommerceshopping.dto.OrderDTO;
import com.wipro.developmentprogram.ecommerceshopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderController {


    private final OrderService orderService;
    private OrderDTO orderDTO;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        this.orderDTO = new OrderDTO();
    }

    protected List<OrderDTO> getReports() {
        return this.orderService.listAll().stream().
                map(order -> this.orderDTO.entityToDTO(order)).
                collect(Collectors.toList());
    }

    protected OrderDTO getOrderDetails(Long orderNumber) {
        return this.orderDTO.entityToDTO(this.orderService.findById(orderNumber));
    }
}
