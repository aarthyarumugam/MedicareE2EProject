Feature: DB Verification Tests

  Background: 
    Given I have launched the medicare application
    And I click on the Login Link

  Scenario Outline: This sceanrio is to verify admin login
    When I enter the username as "<UserName>" and Password as "<Password>"
    And I click on the Login Button
    Then I click on Manage Product and Add new category
    And I verify in DB if the new category is added

    Examples: 
      | UserName     | Password |
      | vk@gmail.com | admin    |

  Scenario Outline: This sceanrio is to verify the Payment process for User in DB
    When I enter the username as "<UserName>" and Password as "<Password>"
    And I click on the Login Button
    And I click on View Products
    And I select and add the products to the cart
    Then I click on checkout
    And I enter payment details
    Then I verify if I am able to see order confirmed message
    And I verify in DB if new order is added

    Examples: 
      | UserName              | Password |
      | aarthytest6@gmail.com | test1234 |
