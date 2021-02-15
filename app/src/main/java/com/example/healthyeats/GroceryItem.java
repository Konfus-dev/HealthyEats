package com.example.healthyeats;

public class GroceryItem {
    private String name;
    private String image;
    private int quantity;
    private double price;

//    Grocery Item Constructor
    public GroceryItem(String name, String image, int quantity, double price) {
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
    }

//    Getters
    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

//    Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
