package com.wipro.developmentprogram.ecommerceshopping.repository;

import com.wipro.developmentprogram.ecommerceshopping.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    List<Item> findAllByOrderByCategoryAscSKUIdAsc();

    Optional<Item> findBySKUId(String SKUId);

    void deleteBySKUId(String SKUId);
}
