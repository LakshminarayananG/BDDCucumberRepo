package com.test.lakshmi.cucumber.stepdefinitions;

import com.test.lakshmi.selenium.pageactions.MyAccountActions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccount extends MyAccountActions {

    @When("I navigate to personal information page")
    public void navigateToPersonalInfo()
    {
    clickMyAccount();
    clickPersonalInfo();
    }
    
    
    
    @Then("^I update FirstName (.+) in personal information page using password (.+) and submit$$")
    public void updateFirstName(String updatedName , String password){
        changeFirstName(updatedName,password);
        savePersonalInfoChanges();
        validateConfirmationMessage();
    }
    
    
    
    @Then("^validate if the updated first name is replicated$")
    public void verifyFirstName(){
        validateChanedFirstName();
    }


}
