package com.wipro.developmentprogram.ecommerceshopping.controller;

import com.wipro.developmentprogram.ecommerceshopping.dto.CategoryDTO;
import com.wipro.developmentprogram.ecommerceshopping.dto.ItemDTO;
import com.wipro.developmentprogram.ecommerceshopping.model.Category;
import com.wipro.developmentprogram.ecommerceshopping.model.Item;
import com.wipro.developmentprogram.ecommerceshopping.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ItemController {

    private final ItemService itemService;
    private ItemDTO itemDTO;
    private CategoryDTO categoryDTO;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
        this.itemDTO = new ItemDTO();
        this.categoryDTO = new CategoryDTO();
    }

    // GET
    public ItemDTO findItem(String SKUId) {
        return itemService.findById(SKUId).isPresent()
                ? itemDTO.entityToDTO(itemService.findById(SKUId).get())
                : null;
    }


    // POST
    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String addItemForm(@Valid @ModelAttribute ItemDTO item) {
        itemService.create(item);
        return "redirect:/adminDashboard";
    }


    // PUT
    @RequestMapping(value = {"/updateItem"}, method = RequestMethod.POST)
    public ModelAndView updateItem(@Valid @ModelAttribute ItemDTO item, ModelMap model, HttpServletRequest request) {
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        model.addAttribute("itemEdit", itemDTO.entityToDTO(itemService.update(item)));
        return new ModelAndView("redirect:/adminEditItem", model);
    }


    // DELETE
    @RequestMapping(value = {"/adminDeleteItem"}, method = RequestMethod.POST)
    public String deleteItem(@ModelAttribute ItemDTO item) {
        itemService.delete(item.getSKUId());
        return "redirect:/adminDashboard";
    }


    protected List<ItemDTO> getItems() {
        return itemService.listAll().stream().
                map(item -> itemDTO.entityToDTO(item)).
                collect(Collectors.toList());
    }

    protected ItemDTO getViewItem(String SKUId) {
        return itemDTO.entityToDTO(itemService.findById(SKUId).get());
    }

    protected Set<String> getCategories() {
        return itemService.listAll().stream().
                map(item -> item.getCategory().getName()).
                sorted(Comparator.naturalOrder()).
                collect(Collectors.toCollection(TreeSet::new));
    }

}
