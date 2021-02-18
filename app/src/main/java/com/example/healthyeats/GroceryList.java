package com.example.healthyeats;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.Collections;


public class GroceryList extends AppCompatActivity {
    LinearLayout linearLayout;
    LayoutParams layoutparams;
    private ArrayList<GroceryItem> groceryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_grocerylist);
        linearLayout = findViewById(R.id.groceryListStart);

        addGroceryItem();
    }

    //Constructor
    public GroceryList() {}

    // Dynamically add card views on to grocery page
    private void addGroceryItem() {
        LinearLayout row = null;
        int groceryItem = this.groceryList.size();
        boolean newRow = false;

        for (int i = 0; i < groceryItem; i++) {
            // Create new horizontal layout within the vertical layout
            if (newRow) {
                newRow = false;
                row = new LinearLayout(this);
                row.setOrientation(LinearLayout.VERTICAL);
                // Might need to set layout params in respect to parent here...

                linearLayout.addView(row);
            }

            // Card on the left side
            if (i % 2 == 0) {
                CardView left = new CardView(new ContextThemeWrapper(GroceryList.this, R.style.groceryListCardViewLeft), null, 0);
                row.addView(left);
                LinearLayout inner = new LinearLayout(this);
                inner.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT
                ));
                inner.setOrientation(LinearLayout.VERTICAL);
                left.addView(inner);
                addGroceryContent("Lorem", 5.00, "img", inner);
            // Card on the right side
            } else {
                newRow = true;
                CardView right = new CardView(new ContextThemeWrapper(GroceryList.this, R.style.groceryListCardViewRight), null, 0);;
                row.addView(right);
                LinearLayout inner = new LinearLayout(this);
                inner.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT
                ));
                inner.setOrientation(LinearLayout.VERTICAL);
                right.addView(inner);
                addGroceryContent("Lorem", 2.00, "img", inner);
            }

            addLineSeperator();
        }
    }

    private void addGroceryContent(String name, double price, String image, LinearLayout parent) {
        // Creates grocery Image
        ImageButton groceryImage = new ImageButton(new ContextThemeWrapper(GroceryList.this, R.style.groceryItemImage), null, 0);

        // Sets name of grocery item
        TextView groceryName = new TextView(this);
        groceryName.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT
        ));

        groceryName.setTextAppearance(this, R.style.groceryItemName);
        groceryName.setText("Name");

        // Sets price of grocery item
        TextView groceryPrice = new TextView(this);
        groceryPrice.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT
        ));
        groceryPrice.setTextAppearance(this, R.style.groceryItemPrice);
        groceryPrice.setText("$" + String.valueOf(price));

        parent.addView(groceryImage);
        parent.addView(groceryName);
        parent.addView(groceryPrice);
    }

    private void addLineSeperator() {
        LinearLayout lineLayout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2);
        params.setMargins(0, 10, 0, 10);
        lineLayout.setLayoutParams(params);
        linearLayout.addView(lineLayout);
    }

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
