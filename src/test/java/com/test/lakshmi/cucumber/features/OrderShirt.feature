Feature: Order T-Shirt online

  @Regression
  Scenario Outline: Order T-Shirt online and verify Order History
    Given I launch the automationpractice
    And I login to the application using <userName> and <password>
    And I clear the cart if any items are added to it
    When I navigate to T-Shirts menu and add a product to basket
    And I validate the summary and confirm order
    Then I navigate to order History page and validate the details
    And I logout from the application
    Examples:
      |userName           |password   |
      |laksvijay07@gmail.com |Samplogin123 |
