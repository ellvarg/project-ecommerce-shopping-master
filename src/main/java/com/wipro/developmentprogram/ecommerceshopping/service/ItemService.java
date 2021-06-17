package com.wipro.developmentprogram.ecommerceshopping.service;


import com.wipro.developmentprogram.ecommerceshopping.dto.ItemDTO;
import com.wipro.developmentprogram.ecommerceshopping.model.Category;
import com.wipro.developmentprogram.ecommerceshopping.model.Item;
import com.wipro.developmentprogram.ecommerceshopping.repository.ItemRepository;
import com.wipro.developmentprogram.ecommerceshopping.validations.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {

    private final ItemRepository repository;
    private ValidationUtils validationUtils;

    @Autowired
    public ItemService(ItemRepository repository) {
        this.repository = repository;
        this.validationUtils = new ValidationUtils();
    }

    public Item create(ItemDTO itemDTO) {
        try {
            return findById(itemDTO.getSKUId()).isEmpty()
                    && validationUtils.isValidSKU(itemDTO.getSKUId())
                    && verify(itemDTO) ?
                    repository.save(
                            new Item(
                                    itemDTO.getCategory().dtoToEntity(itemDTO.getCategory()),
                                    itemDTO.getTitle(),
                                    itemDTO.getSKUId(),
                                    itemDTO.getDescription(),
                                    itemDTO.getPrice()))
                    : null;
        } catch (UnknownError error) {
            System.out.println("Unexpected error occurred");
            return null;
        }

    }

    public Item update(ItemDTO itemDTOUpdate) {
        try {
            Item item = findById(itemDTOUpdate.getSKUId()).isPresent()
                    ? findById(itemDTOUpdate.getSKUId()).get()
                    : null;

            return item != null
                    && verify(itemDTOUpdate)
                    ? repository.save(item.update(
                    item.getSKUId(),// necessary insert manually the id
                    itemDTOUpdate.getCategory().
                            dtoToEntity(itemDTOUpdate.getCategory()),
                    itemDTOUpdate.getTitle(),
                    itemDTOUpdate.getDescription(),
                    itemDTOUpdate.getPrice()))
                    : null;
        } catch (UnknownError error) {
            System.out.println("Unexpected error occurred");
            return null;
        }
    }

    public Optional<Item> findById(String SKUId) {
        return repository.findBySKUId(SKUId);
    }

    public List<Item> listAll() {
        return repository.findAllByOrderByCategoryAscSKUIdAsc();
    }

    public void delete(String SKUId) {
        repository.deleteBySKUId(SKUId);
    }

    private boolean verify(ItemDTO itemDTO) {
        try {
            return validationUtils.isValidCategory(itemDTO.getCategory().dtoToEntity(itemDTO.getCategory()))
                    && validationUtils.isValidTitle(itemDTO.getTitle())
                    && validationUtils.isValidDescription(itemDTO.getDescription())
                    && validationUtils.isValidPrice(String.valueOf(itemDTO.getPrice()));
        } catch (UnknownError error) {
            System.out.println("Unexpected error occurred");
            return false;
        }
    }

}
