package org.thoughtworks;

public class Item {

    private String name;
    private double price;
    private ItemType type;
    private boolean isImported;

    public Item(String name, double price, ItemType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Item(String name, double price, ItemType type, boolean isImported) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.isImported = isImported;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ItemType getType() {
        return type;
    }

    public boolean isImported() {
        return isImported;
    }
}
