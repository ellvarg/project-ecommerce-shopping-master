package com.wipro.developmentprogram.ecommerceshopping.service;

import com.wipro.developmentprogram.ecommerceshopping.dto.SiteDTO;
import com.wipro.developmentprogram.ecommerceshopping.model.Site;
import com.wipro.developmentprogram.ecommerceshopping.validations.ValidationUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SiteService {

    private ValidationUtils validationUtils = new ValidationUtils();
    private Site site = new Site();

    public Site setSiteName(SiteDTO siteDTO) {
        verify(siteDTO.getName());
        site.setName(siteDTO.getName());
        return site;
    }

    public Site getSiteName() {
        return site;
    }

    private boolean verify(String name) {
        return validationUtils.isValidSiteName(name);
    }

}
