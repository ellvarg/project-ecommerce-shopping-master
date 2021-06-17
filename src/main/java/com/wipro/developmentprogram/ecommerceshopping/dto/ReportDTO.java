package com.wipro.developmentprogram.ecommerceshopping.dto;

import com.wipro.developmentprogram.ecommerceshopping.model.Order;
import com.wipro.developmentprogram.ecommerceshopping.model.Report;

import java.util.Set;

public class ReportDTO {

    private Set<Order> orders;

    public ReportDTO(Report report) {
        this.orders = report.getOrders();
    }

    public ReportDTO entityToDTO(Report entity){
        return new ReportDTO(entity);
    }

    public Report dtoToEntity(ReportDTO dto){
        return new Report(dto.getOrders());
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
