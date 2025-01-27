package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(String name, int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price can't be negative.");
        }
        items.add(new Item(name, price));
    }

    public int getItemCount() {
        return items.size();
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public List<String> getItemNames() {
        List<String> names = new ArrayList<>();
        for (Item item : items) {
            names.add(item.getName());
        }
        return names;
    }

    public boolean removeItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(name)) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    private static class Item {
        private final String name;
        private final int price;

        public Item(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }
}
