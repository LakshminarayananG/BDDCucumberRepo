package com.test.lakshmi.selenium.pageactions;

import com.test.lakshmi.selenium.pagelocators.Login;

public class LoginPageActions extends Login {

    public void clickSignIn() {
        click(btnLogin);
    }

    public void enterUserName(String value) {
        enterValue(txtUser, value);
    }

    public void enterPassword(String value) {
        enterValue(txtPassword, value);
    }

    public void clickLogin() {
        click(btnSignin);
    }

    public void clickSignOut() {
        click(btnSignOut);
    }

}
