@login
Feature: Login Test on Demo Web Shop

  Scenario:Login with valid credentials
    Given navigate to the Demo Web Shop
    When click on login button on header
    Then should be show Welcome Please Sign In
    And enter the valid email "test@sample"
    And enter the valid password "password"
    And click on login button
    Then should be logged in successfully
