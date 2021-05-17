package com.test.lakshmi.selenium.framework;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.test.lakshmi.selenium.enums.TestContext;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

public class GenericWrapperFunctions {

    protected WebDriver driver = DriverManager.getInstance().getDriver();

    
    
    
	 
    
    /**
     * Function Description: To attach screenshot to extent report
     * @param scenario
     * @throws IOException
     * @return void
     * @author Lakshminarayanan Ganesan
     */

		public void addScreenshot(Scenario scenario) throws IOException {
		  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		  scenario.attach(fileContent, "image/png", "screenshot");
		
		}

   
	/**
	 * Function Description: scenario context to transfer data between step definitions
	 * @param key
	 * @param value
	 * @throws n/a
	 * @return void
	 * @author Lakshminarayanan Ganesan
	 */
		
    public void setScenarioContext(TestContext key, Object value){
        DriverManager.getInstance().setContext(key,value);
    }
    
    
    public String getScenarioContext(TestContext key){
        return DriverManager.getInstance().getContext(key).toString().trim();
    }

   
    /**
     * Function Description: To make driver wait for specified time
     * @return n/a
     * @param milliSeconds
     * @return void
     * @author Lakshminarayanan Ganesan
     */

    public void waitFor(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Function Description: To make driver wait for an extended period of time until elements are visible
     * @param by
     * @param timeOutInSeconds
     * @return void
     * @author Lakshminarayanan Ganesan
     */

    public void waitUntilElementVisible(By by, long timeOutInSeconds) {
        (new WebDriverWait(driver, timeOutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

     
    /**
     * Function Description: To make driver wait for an extended period of time until elements are clickable
     * @param by
     * @param timeOutInSeconds
     * @return void
     * @author Lakshminarayanan Ganesan
     */

    public void waitUntilElementClickable(By by, long timeOutInSeconds) {
        (new WebDriverWait(driver, timeOutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(by));
    }
    
    /**
     * Function Description: Function to add log message to log and Extent report
     * @param String
     * @throws n/a
     * @return void
     * @author Lakshminarayanan Ganesan
     */

    public static void addStepLog(String message) {
        Calendar calendar = Calendar.getInstance();
        ExtentCucumberAdapter.addTestStepLog(message);
        Logger logger = LoggerFactory.getLogger(calendar.getTime() + "\t" + "Step");
        logger.info(message);


    }

       
    /**
     * Function Description: Function to add error message to log and Extent report
     * @param String
     * @throws n/a
     * @return void
     * @author Lakshminarayanan Ganesan
     */

    public static void addStepError(String message) {
        Calendar calendar = Calendar.getInstance();
        ExtentCucumberAdapter.addTestStepLog(message);
        Logger logger = LoggerFactory.getLogger(calendar.getTime() + "\t" + "Step");
        logger.error(message);
        Assert.fail(message);

    }

    
    /**
     * Function Description: To wait until the web page loads completely
     * @param timeOutInSeconds
     * @return void
     * @author Lakshminarayanan Ganesan
     */
    public void waitForPageLoad(long timeOutInSeconds) {

        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(pageLoadCondition);
        } catch (Exception e) {
            addStepError("Timeout waiting for Page Load Request to complete.<br><b>Exception : </b>" + e);
        }

    }

       
    /**
     * Function Description: TO enter string value into a text field
     * @param by
     * @param Value
     * @return void
     * @author Lakshminarayanan Ganesan
     */

    public void enterValue(By by, String Value) {
        try {
            waitUntilElementVisible(by, 90);
            WebElement field = driver.findElement(by);
            if (field.isDisplayed()) {
                try {
                    field.clear();
                } catch (Exception e) {
                    addStepLog("Warning - Element must be user-editable in order to clear it");
                }
                field.sendKeys(Value);
                addStepLog(Value + " entered in " + by);
            }

        } catch (NoSuchElementException e) {
            addStepError("Unable to find the element -- " + by + " The exception message is : "
                    + e.getMessage());
        } catch (Exception e) {
            addStepError("Operation Failed, Exception: " + e.getMessage());
        }
    }

    
    /**
     * Function Description: To click on a webelement in a webpage
     * @param by
     * @return void
     * @author Lakshminarayanan Ganesan
     */

    public void click(By by) {
        try {
            waitUntilElementClickable(by,20);
            driver.findElement(by).click();
        }
        catch (Exception e){
            addStepError("unable to click the element :" +by+ " caused by exception : " + e);
        }
        waitForPageLoad(20);
    }

   
    
    /**
     * Function Description: To click on a webelement in a web page using Javascript
     * @param by
     * @param name
     * @return void
     * @author Lakshminarayanan Ganesan
     */

    public void clickUsingJavaScript(By by, String name) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(by));
            addStepLog(name + " is clicked");
        } catch (NoSuchElementException e) {
            addStepError(name + " is not clicked" + e.getMessage());
        }
    }


    /**
     * Function Description: To select a specified value from the dropdown
     * @param by
     * @param item
     * @return void
     * @author Lakshminarayanan Ganesan
     */
    public void selectFromDropdown(By by, String item) {
        waitUntilElementVisible(by,20);
        Select dropDownList = new Select(driver.findElement(by));
        dropDownList.selectByVisibleText(item);
    }
    
    
      
    /**
     * Function Description: To scroll to a specific element
     * @param by
     * @return void
     * @author Lakshminarayanan Ganesan
     */

    protected void scrollByLocator(By by ) {

            try {
                waitUntilElementVisible(by, 30);
                WebElement element = driver.findElement(by);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
                addStepLog("Page Scrolled down to " +by+ " successfully!");
            } catch (Exception e) {
                addStepError("Operation Failed with Exception:" + e.getMessage());
            }
        }
    
  
    /**
     * Function Description: TO mouse hover on a specific element using Actions class
     * @param by
     * @param msgdesc
     * @return void
     * @author Lakshminarayanan Ganesan
     */

    protected void mouseHoverToElement(By by,String msgdesc) {
        try {
            waitUntilElementVisible(by, 20);
            if(driver.findElement(by).isEnabled()) {
                Actions actions = new Actions(driver);
                actions.moveToElement(driver.findElement(by)).build().perform();
                addStepLog(msgdesc + " is hovered");
            }

        } catch (NoSuchElementException e) {
            addStepError("Unable to find the element -- " + by +". The exception message is :" + e.getMessage());

        } catch (Exception e1) {
            addStepError("Operation Failed and Exception:" + e1.getMessage());
        }
    }

   
    /**
     * Function Description: To validate the text using string equals function
     * @param actual
     * @param expected
     * @return void
     * @author Lakshminarayanan Ganesan
     */

    protected void verifyText(String actual , String expected) {

        if (actual.equals(expected))
            addStepLog("Actual and Expected text match : " + actual);
        else
            addStepError("Actual Text : " + actual + " is not same as expected : " + expected);
    }

    
    /**
     * Function Description: To generate random string based on the input length provided
     * @param chars
     * @param length
     * @return String
     * @author Lakshminarayanan Ganesan
     */

    protected String getRandomString(String chars, int length) {
        StringBuilder x = new StringBuilder();
        Random rnd = new Random();
        while (x.length() < length) {
            int index = (int) (rnd.nextFloat() * chars.length());
            x.append(chars.charAt(index));
        }
        String Str = x.toString();
        return Str;

    }
    
    /**
     * Function Description: TO validate partial text match in a string using string contains function
     * @param actual
     * @param expected
     * @return void
     * @author Lakshminarayanan Ganesan
     */
    
    
    protected void verifyTextContains(String actual , String expected) {

        if (actual.contains(expected))
            addStepLog("Actual and Expected text match : " + actual);
        else
            addStepError("Actual Text : " + actual + " is not same as expected : " + expected);

    }

       
    /**
     * Function Description: To get text value from a particular web element
     * @param by
     * @return String
     * @author Lakshminarayanan Ganesan
     */
    protected String getTextFromElement(By by) {
        try {
            waitUntilElementVisible(by, 10);
            WebElement element = driver.findElement(by);
            String result = element.getText().toString().trim();
            return result;
        } catch (NoSuchElementException e) {
            addStepError("Unable to find the element -- " + by +". The exception message is :" + e.getMessage());
            return null;

        } catch (Exception e1) {
            addStepError("Operation Failed and Exception:" + e1.getMessage());
            return null;
        }
    }

    
    


}

