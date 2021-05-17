package com.test.lakshmi.selenium.businesscomponents;
import com.test.lakshmi.selenium.framework.GenericWrapperFunctions;
import com.test.lakshmi.selenium.framework.Settings;
import com.test.lakshmi.selenium.pageactions.LoginPageActions;

import java.util.Properties;

public class GenericFunctions extends GenericWrapperFunctions {
    private static Properties globalProperties = Settings.getInstance();
    LoginPageActions login= new LoginPageActions();

        
    /**
     * This function is to launch the automation practice application
     * @param application
     */

    public void launchApplication(String application){

        String url = null;
        if (application.equalsIgnoreCase("automationpractice"))
            url = globalProperties.getProperty(application);
        else
            addStepError("Application URL is not defined");
        driver.get(url);
        waitForPageLoad(20);
        addStepLog(" Application Launched Successfully : " +url);
    }

    /*    Function to login to the application
        @param : String Username and parameter
    */
    
    /**
     * This function is login to the application using valid login credentials
     * 
     * @param userName
     * @param password
     */

    public void loginToApplication(String userName,String password){

        login.clickSignIn();
        login.enterUserName(userName);
        login.enterPassword(password);
        login.clickLogin();
        waitForPageLoad(30);

    }

}
