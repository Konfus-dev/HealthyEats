package com.healthyeats.controller;

import java.util.Comparator;

public class GroceryItem implements Comparable<GroceryItem>{
    private String name;
    private String image;
    private int quantity;
    private double price;
    private boolean checkOff;
    private boolean display;

//    Grocery Item Constructor
    public GroceryItem(String name, String image, int quantity, double price) {
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.checkOff = false;
        this.display = true;
    }


//  Empty Constructor
    public GroceryItem() {}


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

    public boolean getCheckOff() {
        return checkOff;
    }

    public boolean getDisplay() {
        return display;
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

    public void setCheckOff(boolean check) {
        this.checkOff = check;
    }

    public void setDisplay(boolean disp) {
        this.display = disp;
    }
    @Override
    public int compareTo(GroceryItem g){
        return this.name.compareTo(g.name);
    }
    //Comparator to sort array by item name alphabetically from A-Z
    public static final Comparator<GroceryItem> itemAZComparator = new Comparator<GroceryItem>() {
        @Override
        public int compare(GroceryItem item1, GroceryItem item2) {
            if (item1.getName().compareTo(item2.getName()) < 0) {
                return -1;
            }
            else if (item1.getName().compareTo(item2.getName()) > 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
    };

    //Comparator to sort array by item name alphabetically from Z-A
    public static final Comparator<GroceryItem> itemZAComparator = new Comparator<GroceryItem>() {
        @Override
        public int compare(GroceryItem item1, GroceryItem item2) {
            if (item2.getName().compareTo(item1.getName()) < 0) {
                return -1;
            }
            else if (item2.getName().compareTo(item1.getName()) > 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
    };

    //Comparator to sort array by price low-high
    public static final Comparator<GroceryItem> itemLowHighComparator = new Comparator<GroceryItem>() {
        @Override
        public int compare(GroceryItem item1, GroceryItem item2) {
            if (item1.getPrice() > item2.getPrice()) {
                return 1;
            }

            else if (item1.getPrice() < item2.getPrice()) {
                return -1;
            }

            else {
                return 0;
            }
        }
    };

    //Comparator to sort array by price high-low
    public static final Comparator<GroceryItem> itemHighLowComparator = new Comparator<GroceryItem>() {
        @Override
        public int compare(GroceryItem item1, GroceryItem item2) {
            if (item2.getPrice() > item1.getPrice()) {
                return 1;
            }

            else if (item2.getPrice() < item1.getPrice()) {
                return -1;
            }

            else {
                return 0;
            }
        }
    };
}
