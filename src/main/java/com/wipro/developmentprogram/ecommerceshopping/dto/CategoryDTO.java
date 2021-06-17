package com.wipro.developmentprogram.ecommerceshopping.dto;

import com.wipro.developmentprogram.ecommerceshopping.model.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CategoryDTO {

    @NotBlank(message = "Please enter valid input")
    @Pattern(regexp = "[\\s\\w&&[^_]]{4,30}", message = "Please enter valid input")
    @Size(min = 4, max = 30, message = "Please enter valid input")
    private String name;

    public CategoryDTO(String name) {
        this.name = name;
    }

    public CategoryDTO() {
    }

    public CategoryDTO entityToDTO(Category entity) {
        return new CategoryDTO(entity.getName());
    }

    public Category dtoToEntity(CategoryDTO dto) {
        return new Category(dto.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
