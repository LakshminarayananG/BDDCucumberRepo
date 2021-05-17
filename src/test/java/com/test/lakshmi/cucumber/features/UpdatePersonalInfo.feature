Feature: My Account

  @Smoke @Regression
  Scenario Outline: Update Personal Information (First Name) in my account
    Given I launch the <application>
    And I login to the application using <userName> and <password>
    When I navigate to personal information page
    Then I update FirstName <UpdatedFirstName> in personal information page using password <password> and submit
    Then I navigate to personal information page
    And validate if the updated first name is replicated
    Examples:
      |application        |userName           |password   |UpdatedFirstName |
      |automationpractice |laksvijay07@gmail.com |Samplogin123   |Laks Ganesan     |
