package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveItemSteps {

    private ShoppingCart cart;

    @Given("a cart containing {string} {int} and {string} {int}")
    public void aCartContaining(String item1, int price1, String item2, int price2) {
        cart = new ShoppingCart();
        cart.addItem(item1, price1);
        cart.addItem(item2, price2);
    }

    @When("I remove {string}")
    public void iRemove(String name) {
        cart.removeItem(name);
    }

    @Then("the total price should now be {int}")
    public void theTotalPriceShouldNowBe(int expected) {
        assertEquals(expected, cart.getTotalPrice());
    }
}