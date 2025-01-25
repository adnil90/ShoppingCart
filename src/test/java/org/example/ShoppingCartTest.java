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
}
