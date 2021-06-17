package com.wipro.developmentprogram.ecommerceshopping.dto;

import com.wipro.developmentprogram.ecommerceshopping.model.Site;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SiteDTO {

    @Pattern(regexp = "[\\s\\w&&[^_]]{4,30}", message = "Please enter valid input")
    @Size(min = 4, max = 30, message = "Please enter valid input")
    private String name;

    public SiteDTO(Site site) {
        this.name = site.getName();
    }

    public SiteDTO() {
    }

    public SiteDTO entityToDTO(Site entity) {
        return new SiteDTO(entity);
    }

    public Site dtoToEntity(SiteDTO dto){
        return new Site(dto.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
