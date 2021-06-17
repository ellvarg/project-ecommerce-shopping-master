package com.wipro.developmentprogram.ecommerceshopping.repository;


import com.wipro.developmentprogram.ecommerceshopping.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository  extends JpaRepository<Site,Long> {
}
