package com.test.lakshmi.selenium.framework;

import com.test.lakshmi.selenium.enums.Browser;
import com.test.lakshmi.selenium.enums.TestExecutionMode;

import io.cucumber.java.Scenario;

public class TestParameters {

	private TestParameters() {
	}

	private static TestParameters instance = new TestParameters();

	public static TestParameters getInstance() {
		return instance;
	}

	private TestExecutionMode executionMode;
	private Browser browser;
	private Scenario scenario;

	public TestExecutionMode getExecutionMode() {
		return this.executionMode;
	}

	public Browser getBrowser() {
		return this.browser;
	}

	public Scenario getScenario() {
		return this.scenario;
	}

	public void setExecutionMode(TestExecutionMode executionMode) {
		this.executionMode = executionMode;
	}

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

}
