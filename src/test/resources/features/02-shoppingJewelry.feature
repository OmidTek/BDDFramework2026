@shopping
Feature: Shopping Jewelry
  #I had this login part
  Background:
    Given navigate to the Demo Web Shop
    When click on login button on header
    Then should be show Welcome Please Sign In
    And enter the valid email "test@sample"
    And enter the valid password "password"
    And click on login button
    Then should be logged in successfully

    Scenario: Add jewelry to the cart and proceed to checkout
      When user click on the Jewelry button on top menu
      And user select the Create Your Own Jewelry
      Then user should be on the Create Your Own Jewelry page
      And user fill out following fields
      |Material |Length in cm |Pendant|Qty|
      |Gold (1 mm)|40          |Heart |2  |
      And And the user adds the item to the cart
      And user click on the shopping cart button
      Then user should be on Shopping cart page
      And user mark the agree box and click on checkout button

