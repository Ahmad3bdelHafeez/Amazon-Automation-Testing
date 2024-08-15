@smoke
Feature: F03_ShoppingCart | Users could Add items from the today's deal to the cart

  Scenario: Verify that Items are added to cart correctly
    Given user go to Amazon website
    When  user clicks on All Tab button
    And   user click on Today's Deals
    And   user clicks on second category
    And   user clicks on the first product
    And   user clicks on the second item in the selected product
    And   user add this product with qty equals two
    And   user clicks on the Shopping Cart
    Then  Verify that Items are added to cart correctly
