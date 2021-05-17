package com.test.lakshmi.selenium.pageactions;

import com.test.lakshmi.selenium.enums.TestContext;
import com.test.lakshmi.selenium.pagelocators.OrderConfirmationPage;

public class OrderConfirmationActions extends OrderConfirmationPage {

	public void navigateToTshirts() {
		click(megaMenuTshirt);
	}

	public String getProductPrice() {
		scrollByLocator(plpProductImage);
		mouseHoverToElement(plpProductImage, "product");
		String price = getTextFromElement(plpProductPrice);
		setScenarioContext(TestContext.UNITPRICE, price);
		return price;
	}

	public void addToCart() {
		click(btnAddToCart);
	}

	public void validateCartPrice() {
		verifyText(getTextFromElement(cartProductPrice), getScenarioContext(TestContext.UNITPRICE));
	}

	public void getCartDetails() {
		setScenarioContext(TestContext.QUANTITY, getTextFromElement(productQuantity));
		setScenarioContext(TestContext.SHIPPINGCOST, getTextFromElement(cartShippingCost));
		setScenarioContext(TestContext.TOTALPRICE, getTextFromElement(cartTotalPrice));
		setScenarioContext(TestContext.PRODUCT, getTextFromElement(productName));

	}

	public void proceedToCheckout() {
		click(btnProceedToCheckOut);
	}

	public void validateSummaryPage() {
		verifyText(getTextFromElement(summaryProductPrice), getScenarioContext(TestContext.UNITPRICE));
		verifyText(getTextFromElement(summaryShippingCost), getScenarioContext(TestContext.SHIPPINGCOST));
		setScenarioContext(TestContext.PRICEINCLTAX, getTextFromElement(summaryTotalPriceWithTax));
	}

	public void proceedToCheckoutSummary() {
		click(btnSummaryProceedToCheckOut);
	}

	public void proceedToCheckoutInAddressPage() {
		click(btnAddressProceedToCheckOut);
	}

	public void selectPaymentMethod() {
		click(paymentMode);
		verifyText(getTextFromElement(confirmationTotalAmount), getScenarioContext(TestContext.PRICEINCLTAX));
	}

	public void clickTermsandConditions() {
		driver.findElement(checkBoxTermsOfService).click();
	}

	public void confirmOrder() {
		click(btnOrderConfirmation);
	}

	public void getOrderReference() {
		String orderRef = driver.findElement(orderReferenceNumber).getText().trim();
		int end = orderRef.indexOf(" in the subject of your bank wire.");
		orderRef = orderRef.substring(end - 9, end);
		addStepLog("order Reference number is : " + orderRef);
		setScenarioContext(TestContext.ORDERREF, orderRef);
	}

	public void clickProceedToCheckoutInShippingPage() {
		click(btnShippingConfirmation);
	}
}
