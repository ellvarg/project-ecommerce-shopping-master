package com.wipro.developmentprogram.ecommerceshopping.dto;

import java.util.Set;

public class TemplateEcommerceDTO {

    private final SiteDTO siteDTO;
    private final Set<ItemDTO> itemsDTO;

    public TemplateEcommerceDTO(SiteDTO siteDTO, Set<ItemDTO> itemsDTO) {
        this.siteDTO = siteDTO;
        this.itemsDTO = itemsDTO;
    }

    public SiteDTO getSiteDTO() {
        return siteDTO;
    }

    public Set<ItemDTO> getItemsDTO() {
        return itemsDTO;
    }
}
