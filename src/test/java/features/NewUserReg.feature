Feature: This feature is to create new user for medicare application

  Background: 
    Given I have launched the medicare application

  Scenario: This scenario is to verify new user registration
    When I click on signup link
    Then I fill up the personal details for new user
    And I fill up the address details for the new user and confirms
    Then I am able to see login button for new user login
    Then I enter email and password and login to medicare portal
    And I am able to see newly added username in the welcome page
