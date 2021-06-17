package com.wipro.developmentprogram.ecommerceshopping.model;

import java.util.Set;

public class TemplateEcommerce {

    private final Site site;
    private final Set<Item> items;

    public TemplateEcommerce(Site site, Set<Item> items) {
        this.site = site;
        this.items = items;
    }

    public Site getSite() {
        return this.site;
    }

    public Set<Item> getItems() {
        return this.items;
    }
}
