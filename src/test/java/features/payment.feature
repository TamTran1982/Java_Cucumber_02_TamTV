Feature: Payment feature
  As an automation tester
  I want to create new customer
  So that I want to make sure payment correctly

  @login
  Scenario: Login
    Given I navigate to bank guru site
    When I input username and password
    And I click to Login button
    Then I verify Homepage displayed
    And I quit browser 
     
    
