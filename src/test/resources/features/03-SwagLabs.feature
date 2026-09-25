@test
Feature: Swag Labs Login and Logout

  Scenario Outline: Login with different valid credentials

    Given the user opens the page "https://www.saucedemo.com/"
    When the user enters the username "<user>" and password "<pass>"
    Then the user should be on the main page
    When the user clicks the burger menu
    And the user logs out

    Examples:
      | user                       | pass          |
      | standard_user              | secret_sauce  |
      | locked_out_user            | secret_sauce  |
      | problem_user               | secret_sauce  |
      | performance_glitch_user    | secret_sauce  |
      | error_user                 | secret_sauce  |
      | visual_user                | secret_sauce  |