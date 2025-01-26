package org.example;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        MenuHandler menu = new MenuHandler(cart);
        menu.runMenu();
    }
}