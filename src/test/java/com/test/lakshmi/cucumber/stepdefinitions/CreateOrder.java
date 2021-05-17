package com.test.lakshmi.cucumber.stepdefinitions;

import com.test.lakshmi.selenium.pageactions.MyAccountActions;
import com.test.lakshmi.selenium.pageactions.OrderConfirmationActions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class CreateOrder extends OrderConfirmationActions {

    MyAccountActions myAccountObj = new MyAccountActions();

    @Given("^I navigate to T-Shirts menu and add a product to basket$")
    public void addProductToBasket() {
        navigateToTshirts();
        getProductPrice();
        addToCart();
        waitForPageLoad(20);
        validateCartPrice();
        getCartDetails();
        proceedToCheckout();
        waitForPageLoad(20);
    }

    @Then("I validate the summary and confirm order")
    public void validateOrderSummary() {
        validateSummaryPage();
        proceedToCheckoutSummary();
        proceedToCheckoutInAddressPage();
        clickTermsandConditions();
        clickProceedToCheckoutInShippingPage();
        selectPaymentMethod();
        confirmOrder();
        getOrderReference();

    }

    @And("I navigate to order History page and validate the details")
    public void validateOrderDetails() {

        myAccountObj.clickMyAccount();
        myAccountObj.clickOrderHistory();
        myAccountObj.sortbyOrder();
        myAccountObj.clickOrderDetails();
        myAccountObj.validateOrder();

    }

}
