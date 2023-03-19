Feature: UserPayment Feature

  Background: 
    Given I have launched the medicare application
    And I click on the Login Link

  Scenario Outline: This sceanrio is to verify Payment process for User
    When I enter the username as "<UserName>" and Password as "<Password>"
    And I click on the Login Button
    And I click on View Products
    And I select and add the products to the cart
    Then I click on checkout
    And I enter payment details
    Then I verify if I am able to see order confirmed message

    Examples: 
      | UserName              | Password |
      | aarthytest6@gmail.com | test1234 |
