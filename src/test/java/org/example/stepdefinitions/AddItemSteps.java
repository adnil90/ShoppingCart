package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ShoppingCart;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddItemSteps {

    private ShoppingCart cart;

    @Given("an empty shopping cart")
    public void anEmptyShoppingCart() {
        cart = new ShoppingCart();
    }

    @When("I add {int} item {string} with a price of {int}")
    public void iAddItemWithAPrice(int count, String name, int price) {
        for (int i = 0; i < count; i++) {
            cart.addItem(name, price);
        }
    }

    @Then("the total price should be {int}")
    public void theTotalPriceShouldBe(int expected) {
        assertEquals(expected, cart.getTotalPrice());
    }
}
