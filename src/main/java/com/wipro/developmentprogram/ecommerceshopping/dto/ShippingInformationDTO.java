package com.wipro.developmentprogram.ecommerceshopping.dto;

import com.wipro.developmentprogram.ecommerceshopping.model.ShippingInformation;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ShippingInformationDTO {

    @NotBlank(message = "Please enter valid input")
    @Pattern(regexp = "[\\s\\w&&[^_]]{4,30}", message = "Please enter valid input")
    @Size(min = 4, max = 30,message = "Please enter valid input")
    private String firstName;

    @NotBlank(message = "Please enter valid input")
    @Pattern(regexp = "[\\s\\w&&[^_]]{4,30}", message = "Please enter valid input")
    @Size(min = 4, max = 30, message = "Please enter valid input")
    private String lastName;

    @NotBlank(message = "Please enter valid input")
    @Pattern(regexp = "[^0]{1}[0-9]{9}", message = "Please enter valid input")
    @Size(min = 4, max = 30, message = "Please enter valid input")
    private String phone;

    @NotBlank(message = "Please enter valid input")
    @Email(message = "Please enter valid input")
    @Size(min = 4, max = 30, message = "Please enter valid input")
    private String email;

    @NotBlank(message = "Please enter valid input")
    @Pattern(regexp = ".{4,100}", message = "Please enter valid input")
    @Size(min = 4, max = 100, message = "Please enter valid input")
    private String address;

    public ShippingInformationDTO(ShippingInformation shippingInformation) {
        this.firstName = shippingInformation.getFirstName();
        this.lastName = shippingInformation.getLastName();
        this.phone = shippingInformation.getPhone();
        this.email = shippingInformation.getEmail();
        this.address = shippingInformation.getAddress();
    }

    public ShippingInformationDTO() {
    }

    public ShippingInformationDTO entityToDTO(ShippingInformation entity){
        return new ShippingInformationDTO(entity);
    }

    public ShippingInformation dtoToEntity(ShippingInformationDTO dto){
        return new ShippingInformation(dto.getFirstName(),
                dto.getLastName(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getAddress());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
