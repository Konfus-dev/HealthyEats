package com.healthyeats.controller.grocery;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.healthyeats.R;
import com.healthyeats.model.json.UserJson;
import com.healthyeats.model.recipe.Ingredient;
import com.healthyeats.model.viewModels.GrocerylistViewModel;
import com.healthyeats.model.viewModels.ViewHelper;

import java.util.List;

public class GrocerylistFragment extends Fragment {

    private GrocerylistViewModel grocerylistViewModel;
    LinearLayout groceryList;
    LinearLayout temp;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        grocerylistViewModel =
                new ViewModelProvider(this).get(GrocerylistViewModel.class);
        View root = inflater.inflate(R.layout.fragment_grocerylist, container, false);

        populateGroceryList(root);

        return root;
    }

    public ImageButton createImageButton(View root, ViewHelper rec, Ingredient ing) {
        ImageButton but = new ImageButton(new ContextThemeWrapper(getActivity(), R.style.groceryItemImage), null, 0);
        but.setImageDrawable(root.getResources().getDrawable(R.drawable.checkgreenbackground_icon));
        but.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, rec.toDP(90, getContext())));

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserJson userJson = new UserJson(getContext());
                userJson.deleteFromFileIngredients(ing, getContext());
            }
        });

        return but;
    }

    @SuppressLint("ResourceAsColor")
    public TextView createGroceryItemName(String itemName, ViewHelper rec) {
        TextView name = new TextView(getContext());
        name.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        name.setTextSize(rec.toDP(7, getContext()));

        // Margin
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) name.getLayoutParams();
        layoutParams.setMargins(rec.toDP(5, getContext()), rec.toDP(5, getContext()), 0, 0);
        name.requestLayout();

        name.setText(itemName);
        return name;
    }

    public TextView createGroceryItemQuantity(String quantity, ViewHelper rec, String measurement) {
        TextView quan = new TextView(getContext());
        quan.setTextAppearance(getActivity(), R.style.groceryItemPrice);
        quan.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        quan.setText("Quantity: " + quantity + " " + measurement);

        quan.setTextSize(rec.toDP(5, getContext()));

        // Margin
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) quan.getLayoutParams();
        layoutParams.setMargins(rec.toDP(5, getContext()), rec.toDP(5, getContext()), 0, 0);
        quan.requestLayout();

        return quan;
    }

    public void createInnerLayoutCard(LinearLayout parent, ViewHelper rec, View root, Ingredient ingred) {
        LinearLayout inner = new LinearLayout(getContext());
        inner.setLayoutParams(new LinearLayout.LayoutParams(rec.toDP(150, getContext()), rec.toDP(160, getContext())));

        // Margin
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) inner.getLayoutParams();
        layoutParams.setMargins(rec.toDP(30, getContext()), rec.toDP(10, getContext()), 0, 0);
        inner.requestLayout();

        inner.setOrientation(LinearLayout.VERTICAL);

        inner.setBackgroundColor(getResources().getColor(R.color.white));

        parent.addView(inner);
        inner.addView(createImageButton(root, rec, ingred));
        inner.addView(createGroceryItemName(ingred.getName(), rec));
        inner.addView(createGroceryItemQuantity(ingred.getAmount(), rec, ingred.getMeasurement()));
    }

    public void populateGroceryList(View root) {
        groceryList = root.findViewById(R.id.groceryListStart);

        ViewHelper rec = new ViewHelper();
        UserJson userJson = new UserJson(getContext());
        List<Ingredient> yourIngredients = rec.getIngredient(getContext(), userJson);
        if(yourIngredients == null){
            return;
        }
        for (int i = 0; i < yourIngredients.size(); i++) {
            if (i % 2 == 0) {
                temp = new LinearLayout(getContext());
                temp.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                groceryList.addView(temp);
            }

            createInnerLayoutCard(temp, rec, root, yourIngredients.get(i));
        }
    }

}