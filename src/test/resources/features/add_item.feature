Feature: Shopping Cart
  As a customer
  I want to add an item to my shopping cart
  So that I can see the total price of my selected items update accordingly

  Scenario: Add an item to the shopping cart
    Given an empty shopping cart
    When I add 1 item "Milk" with a price of 25
    Then the total price should be 25

