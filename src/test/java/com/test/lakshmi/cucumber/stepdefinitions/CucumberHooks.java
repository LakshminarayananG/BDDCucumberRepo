package com.test.lakshmi.cucumber.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

import com.test.lakshmi.selenium.framework.DriverManager;
import com.test.lakshmi.selenium.framework.GenericWrapperFunctions;

public class CucumberHooks {

    GenericWrapperFunctions utils = new GenericWrapperFunctions();

    @Before
    public void setUp(Scenario scenario) {
        DriverManager.getInstance().getTestParameters().setScenario(scenario);
        utils.addStepLog("Execution started for Scenario: " +DriverManager.getInstance().getTestParameters().getScenario().getName() );

    }
    @After
    public void tearDown(Scenario scenario){
        DriverManager.getInstance().closeDriver();
        utils.addStepLog("Execution completed for Scenario: " +DriverManager.getInstance().getTestParameters().getScenario().getName() + " and driver closed");
    }

    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        utils.addScreenshot (scenario);
    }

}

