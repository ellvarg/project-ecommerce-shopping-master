package com.wipro.developmentprogram.ecommerceshopping.dto;

import com.wipro.developmentprogram.ecommerceshopping.model.PaymentMethod;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class PaymentMethodDTO {

    @NotBlank(message = "Please enter valid input")
    @Pattern(regexp = "[^0]{1}[0-9]{15}", message = "Please enter valid input")
    @Size(min = 16, max = 16, message = "Please enter valid input")
    private String cardNumber;

    @NotBlank(message = "Please enter valid input")
    @FutureOrPresent(message = "Please enter valid input")
    private LocalDate expiryDate;

    @NotBlank(message = "Please enter valid input")
    @Pattern(regexp = "[^0]{1}[0-9]{2}", message = "Please enter valid input")
    @Size(min = 3, max = 3, message = "Please enter valid input")
    private int cvv;

    public PaymentMethodDTO(PaymentMethod paymentMethod) {
        this.cardNumber = paymentMethod.getCardNumber();
        this.expiryDate = paymentMethod.getExpiryDate();
        this.cvv = paymentMethod.getCvv();
    }

    public PaymentMethodDTO() {
    }

    public PaymentMethodDTO entityToDTO(PaymentMethod entity){
        return new PaymentMethodDTO(entity);
    }

    public PaymentMethod dtoToEntity(PaymentMethodDTO dto){
        return new PaymentMethod(dto.getCardNumber(),
                dto.getExpiryDate(),
                dto.getCvv());
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
