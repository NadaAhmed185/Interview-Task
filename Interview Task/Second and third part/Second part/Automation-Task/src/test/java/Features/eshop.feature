Feature: Vodafone eShop Shopping Cart

  Scenario: Add items to the cart
    Given the user is on the Vodafone eShop homepage
    And the user closes cookie popUp
    And the user is logged in with mobile phone  and password
    When the user selects 1 items to add to the cart
    And the user searches for another item to add to the cart
    Then the items should be added to the cart successfully

