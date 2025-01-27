package org.example;

import java.util.Scanner;
import java.util.List;

public class MenuHandler {

    private final ShoppingCart cart;
    private final Scanner scanner;

    public MenuHandler(ShoppingCart cart) {
        this.cart = cart;
        this.scanner = new Scanner(System.in);
    }

    public void runMenu() {
        while (true) {
            System.out.println(
                    "\n--- Welcome to the Shopping Cart ---" +
                            "\n 1. Add item to shopping cart" +
                            "\n 2. Remove item from shopping cart" +
                            "\n 3. Show all items in the shopping cart" +
                            "\n 4. Show the shopping carts total price" +
                            "\n 5. Quit the shopping cart" +
                            "\n Choose an alternative: (1-5): "
            );

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addItem();
                case "2" -> removeItem();
                case "3" -> showItemCountAndNames();
                case "4" -> showTotalPrice();
                case "5" -> {
                    System.out.println("Quit the shopping cart...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Incorrect choice. Try again.");
            }
        }
    }

    private void addItem() {
        System.out.print("Item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Price: ");
        int price;
        try {
            price = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Price must be an integer. Item could not be added.");
            return;
        }

        try {
            cart.addItem(itemName, price);
            System.out.println(itemName + " added to shopping cart.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void removeItem() {
        System.out.print("Which item would you like to remove: ");
        String removeName = scanner.nextLine();
        boolean removed = cart.removeItem(removeName);

        if (removed) {
            System.out.println(removeName + " was removed from the shopping cart.");
        } else {
            System.out.println(removeName + " can not be found in the shopping cart.");
        }
    }

    private void showItemCountAndNames() {
        int itemCount = cart.getItemCount();
        System.out.println("Number of items in the shopping cart: " + itemCount);

        if (itemCount == 0) {
            System.out.println("The shopping cart is empty.");
            return;
        }

        List<String> itemNames = cart.getItemNames();
        System.out.println("Items in the shopping cart:");
        for (String name : itemNames) {
            System.out.println(" - " + name);
        }
    }

    private void showTotalPrice() {
        System.out.println("Total price of shopping cart: " + cart.getTotalPrice() + " SEK");
    }
}