package com.example.healthyeats;
import java.util.ArrayList;
import java.util.Collections;

public class GroceryList {
    private ArrayList<GroceryItem> groceryList;

    //Constructor
    public GroceryList() {}

    //Add ingredient to list
    private void addIngredient(GroceryItem ingredient) {
        this.groceryList.add(ingredient);
    }

    //Remove ingredient from list
    private void removeIngredient(GroceryItem ingredient) {
        this.groceryList.remove(ingredient);
    }

    //Empty the list
    private void emptyList() {
        this.groceryList.clear();
    }

    //Sort by A-Z
    private void sortAZ() {
        Collections.sort(this.groceryList, GroceryItem.itemAZComparator);
    }

    //Sort by Z-A
    private void sortZA() {
        Collections.sort(this.groceryList, GroceryItem.itemZAComparator);
    }

    //Sort by low price - high price
    private void sortLowHigh() {
        Collections.sort(this.groceryList, GroceryItem.itemLowHighComparator);
    }

    //Sort by high price - low price
    private void sortHighLow() {
        Collections.sort(this.groceryList, GroceryItem.itemHighLowComparator);
    }
}
