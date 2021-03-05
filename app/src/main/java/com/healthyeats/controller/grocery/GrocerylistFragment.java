package com.healthyeats.controller.grocery;

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
import com.healthyeats.model.recipe.Recipe;
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

    public ImageButton createImageButton(View root) {
        ImageButton but = new ImageButton(new ContextThemeWrapper(getActivity(), R.style.groceryItemImage), null, 0);
        but.setImageDrawable(root.getResources().getDrawable(R.drawable.checkgreenbackground_icon));

        return but;
    }

    public TextView createGroceryItemName(String itemName) {
        TextView name = new TextView(new ContextThemeWrapper(getActivity(), R.style.groceryItemName), null, 0);
        name.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        name.setText(itemName);

        return name;
    }

    public TextView createGroceryItemQuantity(String quantity) {
        TextView quan = new TextView(new ContextThemeWrapper(getActivity(), R.style.groceryItemName), null, 0);
        quan.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        quan.setText(quantity);

        return quan;
    }

    public void createInnerLayoutCard(LinearLayout parent, ViewHelper rec, View root, Ingredient ingred) {
        LinearLayout inner = new LinearLayout(getContext());
        inner.setLayoutParams(new LinearLayout.LayoutParams(rec.toDP(150, getContext()), ViewGroup.LayoutParams.MATCH_PARENT));

        // Margin
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) inner.getLayoutParams();
        layoutParams.setMargins(rec.toDP(30, getContext()), rec.toDP(10, getContext()), 0, 0);
        inner.requestLayout();

        parent.addView(inner);
        inner.addView(createImageButton(root));
        inner.addView(createGroceryItemName(ingred.getName()));
        inner.addView(createGroceryItemQuantity(ingred.getAmount()));
    }

    public void populateGroceryList(View root) {
        groceryList = root.findViewById(R.id.groceryListStart);

        ViewHelper rec = new ViewHelper();
        UserJson userJson = new UserJson(getContext());
        List<Ingredient> yourIngredients = rec.getIngredient(getContext(), userJson);

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