package com.test.lakshmi.selenium.pageactions;

import com.test.lakshmi.selenium.enums.TestContext;
import com.test.lakshmi.selenium.pagelocators.MyAccountPage;

public class MyAccountActions extends MyAccountPage {

	public void clickMyAccount() {
		click(myAccount);
	}

	public void clickOrderHistory() {
		click(orderHistory);
	}

	public void clickPersonalInfo() {
		click(personalInformation);
	}

	public void sortbyOrder() {
		clickUsingJavaScript(dateSort, "Date sort");
	}

	public void clickOrderDetails() {
		click(btnOrderDetails);
	}

	public String getTotalPriceFromHistory() {
		return getTextFromElement(totalPriceIncTax);
	}

	public void validateOrder() {
		scrollByLocator(orderReference);
		verifyTextContains(getTextFromElement(orderReference), getScenarioContext(TestContext.ORDERREF));
		scrollByLocator(productName);
		verifyTextContains(getTextFromElement(productName), getScenarioContext(TestContext.PRODUCT));
		verifyText(getTextFromElement(productQuantity), getScenarioContext(TestContext.QUANTITY));
		verifyText(getTextFromElement(unitPrice), getScenarioContext(TestContext.UNITPRICE));
		verifyText(getTextFromElement(totalPriceIncTax), getScenarioContext(TestContext.PRICEINCLTAX));
	}

	public void changeFirstName(String updatedName, String password) {
		updatedName = updatedName + getRandomString("aeiou", 5);
		enterValue(txtFirstName, updatedName);
		setScenarioContext(TestContext.FIRSTNAME, updatedName);
		enterValue(txtOldPassword, password);
	}

	public void validateChanedFirstName() {
		verifyText(driver.findElement(txtFirstName).getAttribute("value"), getScenarioContext(TestContext.FIRSTNAME));
	}

	public void savePersonalInfoChanges() {
		click(btnSave);
	}

	public void validateConfirmationMessage() {
		if (driver.findElements(successMessage).size() != 0)
			addStepLog("Success Message displayed as expected");
		else
			addStepError("Success message is not displayed");
	}

}
