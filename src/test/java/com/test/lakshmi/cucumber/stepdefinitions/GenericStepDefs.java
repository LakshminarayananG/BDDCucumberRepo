package com.test.lakshmi.cucumber.stepdefinitions;

import com.test.lakshmi.selenium.businesscomponents.GenericFunctions;
import com.test.lakshmi.selenium.pageactions.LoginPageActions;
import com.test.lakshmi.selenium.pageactions.OrderConfirmationActions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class GenericStepDefs extends OrderConfirmationActions {

    GenericFunctions baseobj = new GenericFunctions();
    LoginPageActions loginobj = new LoginPageActions();

    @Given ("^I launch the (.+)$")
    public void i_launch_the_application(String application) throws InterruptedException {
    	baseobj.launchApplication(application);

    }

    @And("^I login to the application using (.+) and (.+)$")
    public void login_to_the_application(String userName, String password){
    	baseobj.loginToApplication(userName,password);

    }

    @And("^I clear the cart if any items are added to it$")
    public void empty_cart(){
        if(driver.findElements(loginobj.cartCount).size()!=0) {
            click(loginobj.cartCount);
            click(loginobj.removeCart);
        }
        else
            addStepLog("Cart is already Empty");

    }

    @And("^I logout from the application$")
    public void signout(){
    	loginobj.clickSignOut();
    }


}
