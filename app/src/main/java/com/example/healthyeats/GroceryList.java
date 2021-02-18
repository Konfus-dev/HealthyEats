package com.example.healthyeats;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

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
                CardView left = createCardView(0);
                row.addView(left);
            // Card on the right side
            } else {
                newRow = true;
                CardView right = createCardView(1);
                row.addView(right);
            }

            addLineSeperator();
        }
    }

    private CardView createCardView(int lr) {
        CardView myCard = new CardView(getApplicationContext());

        // Equivalent of layout_gravity = center here
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        myCard.setLayoutParams(params);
//        android:layout_width="0dp"
//        android:layout_height="150dp"
        myCard.setRadius(4);
//        card_view:cardCornerRadius="4dp"
//        android:layout_weight="1"
//        myCard.wei
        // Left Card
        if (lr == 0) {
//            myCard.mar
//            android:layout_marginRight="15dp"
//            android:layout_marginLeft="30dp"
        // Right Card
        } else if (lr == 1) {
//            android:layout_marginLeft="15dp"
//            android:layout_marginRight="30dp"
        }

        return myCard;
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
