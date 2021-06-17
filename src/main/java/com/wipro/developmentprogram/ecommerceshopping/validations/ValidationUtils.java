package com.wipro.developmentprogram.ecommerceshopping.validations;

import com.wipro.developmentprogram.ecommerceshopping.model.*;

import java.time.LocalDate;
import java.util.List;

public class ValidationUtils {

    // SITE NAME
    public boolean isEmptySiteName(String siteName) {
        return true;
    }

    public boolean isValidSiteName(String siteName) {
        /* Require: min. 4 characteres
                    max. 30 characteres
                    alphanumeric & space only
           Message: Invalid input -> "Please enter valid input"
         */
        return siteName.length() >= 4
                && siteName.length() <= 30
                && siteName.matches("[\\s\\w&&[^_]]{4,30}");
    }

    // ITEM
    public boolean isEmptyItemList(List<Item> list) {
        /* Message: Empty list -> "No records to display"
         */
        return list.isEmpty();
    }

    public boolean isValidCategory(Category category) {
        /* Require: min. 4 characteres
                    max. 30 characteres
                    alphanumeric & space only
           Message: Invalid input -> "Please enter valid input"
         */
        return category.getName().length() >= 4
                && category.getName().length() <= 30
                && category.getName().matches("[\\s\\w&&[^_]]{4,30}");
    }

    public boolean isValidTitle(String title) {
        /* Require: min. 4 characteres
                    max. 30 characteres
                    alphanumeric & space only
           Message: Invalid input -> "Please enter valid input"
         */
        return title.length() >= 4
                && title.length() <= 30
                && title.matches("[\\s\\w&&[^_]]{4,30}");
    }

    public boolean isValidSKU(String SKU) {
        /* Require: min. 4 characteres
                    max. 30 characteres
                    alphanumeric & space only
                    should be unique
           Message: Invalid input -> "Please enter valid input"
                    Duplicate SKU -> "SKU Id already exists"
         */
        return SKU.length() >= 4
                && SKU.length() <= 30
                && SKU.matches("[\\s\\w&&[^_]]{4,30}");
    }

    public boolean isValidDescription(String title) {
        /* Require: min. 4 characteres
                    max. 100 characteres
           Message: Invalid input -> "Please enter valid input"
         */
        return title.length() >= 4
                && title.length() <= 100
                && title.matches(".{4,100}");
    }

    public boolean isValidPrice(String price) {
        /* Require: Only numbers
                    No decimal values
                    Possible value range: 1 to 100000
           Message: Invalid input -> "Please enter valid input"
         */
        Integer p = Integer.parseInt(price);
        return p >= 1 && p <= 100000;
    }

    // ITEM SHOPPING
    public boolean isValidQuantity(String quantity) {
        /* Require: Only numbers
                    No decimal values
                    Possible value range: 1 to 100000
           Message: Invalid input -> "Please enter valid input"
         */
        Integer q = Integer.parseInt(quantity);
        return q >= 1 && q <= 100000;
    }

    public boolean isEmptyItemShoppingList(List<ItemShopping> list) {
        // TODO it's the same "isEmptyItemList" method
        /* Message: Empty list -> "No records to display"
         */
        return list.isEmpty();
    }

    // ORDER
    public boolean isEmptyOrderList(List<Order> list) {
        // TODO it's the same "isEmptyItemList" method
        /* Message: Empty list -> "No records to display"
         */
        return list.isEmpty();
    }

    public boolean isValidOrderNumber(String orderNumber) {
        /* Require: Only numbers
                    Starts: 1001
           Message: Invalid input -> "Please enter valid input"
         */
        Integer orderN = Integer.parseInt(orderNumber);
        return orderN >= 1001;
    }

    // SHIPPING INFORMATION
    private boolean isValidFirstName(String firstName) {
        /* Require: min. 4 characteres
                    max. 30 characteres
                    alphanumeric & space only
           Message: Invalid input -> "Please enter valid input"
         */
        return firstName.length() >= 4
                && firstName.length() <= 30
                && firstName.matches("[\\s\\w&&[^_]]{4,30}");
    }

    private boolean isValidLastName(String lastName) {
        /* Require: min. 4 characteres
                    max. 30 characteres
                    alphanumeric & space only
           Message: Invalid input -> "Please enter valid input"
         */
        return lastName.length() >= 4
                && lastName.length() <= 30
                && lastName.matches("[\\s\\w&&[^_]]{4,30}");
    }

    private boolean isValidPhone(String phone) {
        /* Require: 10 digit number
                    First digit can't be zero
           Message: Invalid input -> "Please enter valid input"
         */
        return phone.length() == 10 && phone.matches("[^0]{1}[0-9]{9}");
    }

    private boolean isValidEmail(String email) {
        /* Require: min. 10 characteres
                    max. 30 characteres
                    Valid email format
           Message: Invalid input -> "Please enter valid input"
         */
        return email.length() >= 10
                && email.length() <= 30
                && email.matches("^(?=.{1,30}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$");
    }

    private boolean isValidAddress(String address) {
        /* Require: min. 4 characteres
                    max. 100 characteres
           Message: Invalid input -> "Please enter valid input"
         */
        return address.length() >= 4
                && address.length() <= 100
                && address.matches(".{4,100}");
    }

    // PAYMENT METHOD
    private boolean isValidCardNumber(String cardNumber) {
        /* Require: 16 digit number
                    First digit can't be zero
           Message: Invalid input -> "Please enter valid input"
         */
        return cardNumber.length() == 16 && cardNumber.matches("[^0]{1}[0-9]{15}");
    }

    private boolean isValidDateExpiry(LocalDate dateExpiry) {
        /* Require: format: dd/mm/yyyy
                    For single digit date or motnh
                    valid format: 01/01/2019
                    invalid: 1/1/2019
           Message: Invalid input -> "Please enter valid input"
         */
        return LocalDate.now().compareTo(dateExpiry) >= 0;
    }

    private boolean isValidCvv(String cvv) {
        /* Require: 3 digit number
                    First digit can't be zero
           Message: Invalid input -> "Please enter valid input"
         */
        return cvv.length() == 3 && cvv.matches("[^0]{1}[0-9]{2}");
    }

    public boolean isValidPaymentMethod(PaymentMethod paymentMethod) {
        return isValidCardNumber(paymentMethod.getCardNumber()) &&
                isValidDateExpiry(paymentMethod.getExpiryDate()) &&
                isValidCvv(String.valueOf(paymentMethod.getCvv()));
    }


    public boolean isValidShippingInformation(ShippingInformation shippingInformation) {
        return isValidFirstName(shippingInformation.getFirstName()) &&
                isValidLastName(shippingInformation.getLastName()) &&
                isValidPhone(shippingInformation.getPhone()) &&
                isValidEmail(shippingInformation.getEmail()) &&
                isValidAddress(shippingInformation.getAddress());
    }

    public boolean isValidCart(Cart cart) {
        return true;
    }

}