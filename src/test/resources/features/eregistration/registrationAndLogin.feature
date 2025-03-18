Feature: User Registration and Login

  Scenario: User Registration
    Given User is on the registration page
    When User enters registration details 
    And User submits the registration form
    Then User should be registered successfully

  Scenario: User Login
    Given User is on the login page
    When User logs in with "gautam71" and "Gautam@123"
    Then User should be logged in successfully
