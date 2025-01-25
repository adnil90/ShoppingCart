Feature: Shopping Cart
  As a customer
  I want to remove an item from my shopping cart
  So that I can adjust the total price and only keep the items I want to purchase

  Scenario: Remove an item from the shopping cart
    Given a cart containing "Milk" 25 and "Bread" 20
    When I remove "Bread"
    Then the total price should now be 25