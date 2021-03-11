package com.healthyeats.model.grocery;

import java.util.Comparator;

public class GroceryItem implements Comparable<GroceryItem>{
    private String name;
    private String image;
    private int quantity;
    private double price;
    private boolean checkOff;
    private boolean display;

    /**
     * basic constructor for GroceryItem
     */
    public GroceryItem() { }

    /**
     * constructor for GroceryItem
     * @param name the name of the item
     * @param image the file name of the item
     * @param quantity the amount of the item
     * @param price the price of the item
     */
    public GroceryItem(String name, String image, int quantity, double price) {
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.checkOff = false;
        this.display = true;
    }

    /**
     * @return the name of the GroceryItem
     */
    public String getName() {
        return name;
    }

    /**
     * @return file name of the GroceryItem
     */
    public String getImage() {
        return image;
    }

    /**
     * @return the quantity of the GroceryItem
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @return the price of the GroceryItem
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return boolean, has the GroceryItem been checked off
     */
    public boolean getCheckOff() {
        return checkOff;
    }

    /**
     * Simone - I honestly don't know what this variable is
     * @return the display
     */
    public boolean getDisplay() {
        return display;
    }

    /**
     * sets GroceryItem name
     * @param name the name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets GroceryItem image file
     * @param image the file name
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * set the quantity of the GroceryItem
     * @param quantity the quantity of the item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * set the price of the GroceryItem
     * @param price the price of the GroceryItem
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * changes the status of the GroceryItem check
     * @param check has it been check off
     */
    public void setCheckOff(boolean check) {
        this.checkOff = check;
    }

    /**
     * changes the display of GroceryItem
     * @param disp the display
     */
    public void setDisplay(boolean disp) {
        this.display = disp;
    }

    /**
     * compares groceryItems
     * @param g the grocery item to compare
     * @return the int result of the compare
     */
    @Override
    public int compareTo(GroceryItem g){
        return this.name.compareTo(g.name);
    }

    /**
     * Comparator to sort array by item name alphabetically from A-Z
     */
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

    /**
     * Comparator to sort array by item name alphabetically from Z-A
     */
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

    /**
     * Comparator to sort array by price low-high
     */
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

    /**
     * Comparator to sort array by price high-low
     */
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
