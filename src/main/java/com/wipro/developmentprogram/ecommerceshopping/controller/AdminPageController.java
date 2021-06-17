package com.wipro.developmentprogram.ecommerceshopping.controller;

import com.wipro.developmentprogram.ecommerceshopping.dto.ItemDTO;
import com.wipro.developmentprogram.ecommerceshopping.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminPageController {

    @Autowired
    private ItemController itemController;
    @Autowired
    private SiteNameController siteNameController;
    @Autowired
    private OrderController orderController;


    // GET
    @RequestMapping(value = {"/adminAddItem"}, method = RequestMethod.GET)
    public String pageAddItem(Model model) {
        model.addAttribute("item", new ItemDTO());
        return "/admin/adminAddItem";
    }


    @RequestMapping(value = {"/adminDashboard", "/adminDashboard.html", "/admindashboard", "/admindashboard.html"},
            method = RequestMethod.GET)
    public String pageDashboard(Model model) {
        model.addAttribute("siteName", siteNameController.getSiteName());// works!
        model.addAttribute("items", itemController.getItems());// works!
        model.addAttribute("itemView", new ItemDTO());
        return "/admin/adminDashboard";
    }


    @RequestMapping(value = {"/adminEditItem"}, method = RequestMethod.POST)
    public String pageEditItem(@ModelAttribute ItemDTO item, Model model) {
        model.addAttribute("itemEdit", itemController.findItem(item.getSKUId()));
        return "/admin/adminEditItem";
    }


    @RequestMapping(value = {"/adminOrderDetails"}, method = RequestMethod.POST)
    public String pageOrderDetails(@ModelAttribute OrderDTO order, Model model) {
        model.addAttribute("order", orderController.getOrderDetails(order.getOrderNumber()));
        return "/admin/adminOrderDetails";
    }


    @RequestMapping(value = {"/adminReports"}, method = RequestMethod.GET)
    public String pageReports(Model model) {
        model.addAttribute("orders", orderController.getReports());
        return "/admin/adminReports";
    }


    @RequestMapping(value = {"/adminSetsiteName"}, method = RequestMethod.GET)
    public String pageSiteName(Model model) {
        model.addAttribute("siteName", siteNameController.getSiteName());
        return "/admin/adminSetsiteName";
    }


    @RequestMapping(value = {"/adminViewItem"}, method = RequestMethod.POST)
    public String pageViewItem(@ModelAttribute ItemDTO itemDTO, Model model) {
        model.addAttribute("itemView", itemController.getViewItem(itemDTO.getSKUId()));
        return "/admin/adminViewItem";
    }


}
