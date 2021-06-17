package com.wipro.developmentprogram.ecommerceshopping.controller;

import com.wipro.developmentprogram.ecommerceshopping.dto.SiteDTO;
import com.wipro.developmentprogram.ecommerceshopping.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class SiteNameController {

    private final SiteService siteService;
    private SiteDTO siteDTO;

    @Autowired
    public SiteNameController(SiteService siteService) {
        this.siteService = siteService;
        this.siteDTO = new SiteDTO();
    }

    // POST

    @RequestMapping(value = {"/editSiteName"}, method = RequestMethod.POST)
    public String editSiteName(@Valid @ModelAttribute SiteDTO site, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/adminSetsiteName";
        }
        siteService.setSiteName(site);
        return "redirect:/adminDashboard";
    }


    protected SiteDTO getSiteName() {
        return siteDTO.entityToDTO(siteService.getSiteName()); // works !!!
    }


}
