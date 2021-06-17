package com.wipro.developmentprogram.ecommerceshopping.dto;

import com.wipro.developmentprogram.ecommerceshopping.model.Item;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class ItemDTO {

    @NotBlank(message = "Please enter valid input")
    @Pattern(regexp = "[\\s\\w&&[^_]]{4,30}", message = "Please enter valid input")
    @Size(min = 4, max = 30, message = "Please enter valid input")
    private String SKUId;

    @Valid
    private CategoryDTO category;

    @NotBlank(message = "Please enter valid input")
    @Pattern(regexp = "[\\s\\w&&[^_]]{4,30}", message = "Please enter valid input")
    @Size(min = 4, max = 30, message = "Please enter valid input")
    private String title;

    @NotBlank(message = "Please enter valid input")
    @Pattern(regexp = ".{4,100}", message = "Please enter valid input")
    @Size(min = 4, max = 100, message = "Please enter valid input")
    private String description;

    @DecimalMin(value = "1", message = "Please enter valid input")
    @DecimalMax(value = "100000", message = "Please enter valid input")
    private int price;


    public ItemDTO(Item item) {
        this.SKUId = item.getSKUId();
        this.category = new CategoryDTO(item.getCategory().getName());
        this.title = item.getTitle();
        this.description = item.getDescription();
        this.price = item.getPrice();
    }

    public ItemDTO() {

    }

    public ItemDTO entityToDTO(Item entity) {
        return new ItemDTO(entity);
    }

    public Item dtoToEntity(ItemDTO dto) {
        return new Item(category.dtoToEntity(dto.getCategory()),
                dto.getTitle(),
                dto.getSKUId(),
                dto.getDescription(),
                dto.getPrice());
    }

    public String getSKUId() {
        return SKUId;
    }

    public void setSKUId(String SKUId) {
        this.SKUId = SKUId;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
