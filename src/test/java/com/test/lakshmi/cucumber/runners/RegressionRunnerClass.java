package com.test.lakshmi.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "src/test/java/com/test/lakshmi/cucumber/features" , glue = "com.test.lakshmi.cucumber.stepdefinitions" ,
        tags = ("@Regression"), plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class RegressionRunnerClass extends AbstractTestNGCucumberTests {
	
	
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
