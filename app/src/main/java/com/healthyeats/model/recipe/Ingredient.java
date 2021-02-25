package com.healthyeats.model.recipe;

import com.healthyeats.model.grocery.GroceryItem;

public class Ingredient {

    private String name;
    private String measurement;
    private String amount;
    private boolean userHasIngredient;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMeasurement() { return measurement; }
    public void setMeasurement(String measurement) { this.measurement = measurement; }

    public String getAmount() { return amount; }
    public void setAmount(String amount) { this.amount = amount; }

    public boolean CheckIfUserHasIngredient() { return userHasIngredient; }
    public void SetUserHasIngredient(boolean yesNo) { this.userHasIngredient = yesNo; }

    public GroceryItem toGroceryItem() {
        GroceryItem item = new GroceryItem();
        item.setName(name);
        item.setQuantity(Integer.parseInt(amount));

        //Placeholder price
        item.setPrice(.30);
        item.setDisplay(true);
        if (userHasIngredient)
        {
            item.setCheckOff(true);
        }
        else
        {
            item.setCheckOff(false);
        }

        return item;
    }

    public String toString() {
        String ingredientString =
                name + ", " + measurement + ", " + amount;
        return ingredientString;
    }
}
