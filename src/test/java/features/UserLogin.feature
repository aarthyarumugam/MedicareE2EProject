Feature: Login Feature

  Background: 
    Given I have launched the medicare application
    And I click on the Login Link
#
  #Scenario Outline: This sceanrio is to verify user login
    #When I enter the username as "<UserName>" and Password as "<Password>"
    #And I click on the Login Button
#
    #Examples: 
      #| UserName     | Password |
      #| kn@gmail.com |    12345 |

  Scenario Outline: This sceanrio is to verify admin login
    When I enter the username as "<UserName>" and Password as "<Password>"
    And I click on the Login Button

    Examples: 
      | UserName     | Password |
      | vk@gmail.com | admin    |
