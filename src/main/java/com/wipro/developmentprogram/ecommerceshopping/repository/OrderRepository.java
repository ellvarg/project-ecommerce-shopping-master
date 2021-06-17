package com.wipro.developmentprogram.ecommerceshopping.repository;

import com.wipro.developmentprogram.ecommerceshopping.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAllByOrderByOrderNumberAsc();
//    Order findByOrderNumber(String orderNumber);
}
