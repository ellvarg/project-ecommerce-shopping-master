package com.wipro.developmentprogram.ecommerceshopping.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Site extends BaseEntity {

    @Embedded
    private Set<Category> categories;
    private String name;

    public Site(String name) {
        this.name = name;
    }

    public Site() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}

