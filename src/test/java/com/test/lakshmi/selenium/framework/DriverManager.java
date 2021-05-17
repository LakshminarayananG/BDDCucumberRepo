package com.test.lakshmi.selenium.framework;

import org.openqa.selenium.WebDriver;

import com.test.lakshmi.selenium.enums.TestContext;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {

   
	
	/**
	 * Singleton pattern implemented to get only one instance of driver
	 * 
	 * Test Parameters and scenario context defined for the flow of execution
	 */

    private DriverManager(){}
    private static DriverManager instance = new DriverManager();
    public static DriverManager getInstance(){
        return instance;
    }
    
    
    
    /**
     * Threadlocal Implementation to handle multiple threads to support parallel execution
     */
    
    
    private static ThreadLocal<TestParameters> testParameters = new ThreadLocal<TestParameters>();
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    
        
    /**
     * Driver object through getter and setter
     * @param driver
     */
    public void setDriver(WebDriver driver){ DriverManager.driver.set(driver);}
    public WebDriver getDriver() { return driver.get(); }
    public void closeDriver(){
        driver.get().close();
        driver.remove();
    }
    
    
    public void setParameters(TestParameters parameters){ DriverManager.getInstance().testParameters.set(parameters); }
    public TestParameters getTestParameters() { return DriverManager.getInstance().testParameters.get(); }

    
    
    /**
     * Scenario context through getter and setter
     */
    
    private Map<String, Object>scenarioContext ;
    public void ScenarioContext(){
        scenarioContext = new HashMap<>();
    }
    public void setContext(TestContext key, Object value) {
        scenarioContext.put(key.toString(), value);

    }
    public Object getContext(TestContext key){
        return scenarioContext.get(key.toString());
    }

}
