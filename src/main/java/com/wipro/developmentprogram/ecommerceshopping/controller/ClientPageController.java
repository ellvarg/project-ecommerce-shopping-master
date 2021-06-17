package com.wipro.developmentprogram.ecommerceshopping.controller;

import com.wipro.developmentprogram.ecommerceshopping.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientPageController {

    @Autowired
    private ItemController itemController;
    @Autowired
    private SiteNameController siteNameController;
    @Autowired
    private OrderController orderController;
    @Autowired
    private CartController cartController;


    // GET

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String pageHome(Model model) {
        model.addAttribute("siteName", siteNameController.getSiteName());
        model.addAttribute("items", itemController.getItems());
        model.addAttribute("categories", itemController.getCategories());
        model.addAttribute("itemView", new ItemDTO());
        return "/client/home";
    }

    @RequestMapping(value = {"pageViewItem"}, method = RequestMethod.POST)
    public String pageViewDetails(@ModelAttribute ItemDTO itemDTO, Model model) {
        model.addAttribute("siteName", siteNameController.getSiteName());
        model.addAttribute("itemView", itemController.getViewItem(itemDTO.getSKUId()));
//        model.addAttribute("itemShopping",new ItemShoppingDTO());
        return "/client/viewItem";
    }

    @RequestMapping(value = {"cart"}, method = RequestMethod.GET)
    public String pageViewCart(Model model) {
//        model.addAttribute("itemsShopping", );
        return "/client/cart";
    }

    @RequestMapping(value = {"addToCart"}, method = RequestMethod.POST)
    public String postAddToCart(@RequestParam("SKUId") String SKUId,
                                @RequestParam("quantity") Integer quantity, Model model) {
        cartController.addToCart(new ItemShoppingDTO(itemController.getViewItem(SKUId), quantity));
        model.addAttribute("siteName", siteNameController.getSiteName());
        model.addAttribute("itemsCart", cartController.getItemsShopping());
        return "/client/cart";
    }

    public void updateQuantityFromCart() {
        // TODO update data from "Cart" page. (CART) after loads (CART)
    }

    public void deleteRemoveFromCart() {
        // TODO remove data from "Cart" page. (CART) after loads (CART)
    }

    @RequestMapping(value = {"pageCheckout"}, method = RequestMethod.POST)
    public String pageCheckout(@ModelAttribute CartDTO cart, Model model) {
        model.addAttribute("itemsShopping", cart.getItemsShopping());
        model.addAttribute("totalPrice", cart.getTotalPrice());
        model.addAttribute("shipping", new ShippingInformationDTO());
        model.addAttribute("payment", new PaymentMethodDTO());
        return "/client/checkout";
    }

    public OrderDTO postCheckout(OrderDTO orderDTO) {
        // TODO save data from "Checkout" page. (CHECKOUT) after (ORDER CONFIRMATION)
//        try {
//            return orderDTO.entityToDTO(orderService.create(orderDTO));
//        } catch (UnknownError error) {
//            System.out.println("Unexpected error occurred");
//            return null;
//        }
        return null;
    }

    public void getOrderConfirmation() {
        // TODO loads data from "Order Confirmation" page.
        // there is only a order
    }

    public void getViewOrderDetails() {
        // TODO loads data from "Order Confirmation" page. (ORDER CONFIRMATION) after (ORDER DETAILS)
        // there is only a specific order choose
    }


}
