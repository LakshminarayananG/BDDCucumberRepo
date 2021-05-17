# CucumberBDDFramework

## Automation Framework Design

This framework built using different component - Selenium with Java as language binding , TestNG as runner, Cucumber for writing descriptive feature files , Page Object Model with extent report

* Framework Design hierarchy (Multi level inheritance) is maintained as below

GenericWrapperFunctions --> pagelocators --> pageactions --> businesscomponents --> stepdefinitions 

* Selenium framework related components maintained in package com.test.lakshmi.selenium

* Cucumber framework related components (Feature , Step definition, runner files) maintained in package com.test.lakshmi.cucumber

* Execution Mode and Browser parameters are maintained in TestNG XMLS and valid values in enum (src/test/java/com.test.lakshmi.selenium.enums) should be used

* CukeHooks class is used to manage the @Before and @After Scenario functions related to cucumber scenario logic

* WebDriverManager Used for picking the driver file automatically

* TestNG listener is the core driving component used to control the flow of execution

* Property files in src/test/resources/ path
	-Application url and other application related properties are maintained in GlobalSettings.properties file
	-Extent , cucumber reporting configuration maintained in corresponding property files


## Reports

Extent HTML and PDF reports are configured and will be available in /Reports folder. Each of the report folder name are generated based on current time and hence older 
reports will also be available.

## Steps to execute the Test


This repo can be cloned and scenario execution can be done as below

* Using any of the IDE (Eclipse / VSCode / Intellij), the TestNg xml files (located in src/test/resources/TestNGXMLs) can be run

* From command line   : mvn clean test -PrunRegressionTest    ( make sure Java and maven are installed in the machine)









