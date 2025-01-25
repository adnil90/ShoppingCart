package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void addingNewItemIncreasesItemCount() {
        cart.addItem("Milk", 25);
        assertEquals(1, cart.getItemCount(),
                "Item count should be 1 after adding one item");
    }

    @Test
    void addingNewItemUpdatesTotalPrice() {
        cart.addItem("Milk", 25);
        assertEquals(25, cart.getTotalPrice(),
                "Total price should equal the price of the added item");
    }

    @Test
    void addingMultipleItemsSum() {
        cart.addItem("Milk", 25);
        cart.addItem("Bread", 20);
        assertEquals(45, cart.getTotalPrice());
        assertEquals(2, cart.getItemCount());
    }
}
