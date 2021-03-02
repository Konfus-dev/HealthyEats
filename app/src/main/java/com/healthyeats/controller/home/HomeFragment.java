package com.healthyeats.controller.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.healthyeats.R;
import com.healthyeats.model.json.UserJson;
import com.healthyeats.model.recipe.Recipe;
import com.healthyeats.model.viewModels.HomeViewModel;
import com.healthyeats.model.viewModels.ViewHelper;

import java.lang.reflect.Type;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    LinearLayout thisWeeksMeals;
    LinearLayout yourFavorites;
    ViewHelper help = new ViewHelper();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ViewHelper obj = new ViewHelper();

        populateThisWeeksMeals(root, obj);
        populateYourFavorites(root, obj);

        return root;
    }

    public HorizontalScrollView createHorizontalScroll() {
        HorizontalScrollView horiz = new HorizontalScrollView(getContext());
        horiz.setLayoutParams(new CardView.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, help.toDP(298, getContext())));

        // Margin
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) horiz.getLayoutParams();
        layoutParams.setMargins(help.toDP(10, getContext()), help.toDP(10, getContext()), 0, 0);
        horiz.requestLayout();
        horiz.setVerticalScrollBarEnabled(false);
        horiz.setHorizontalScrollBarEnabled(false);

        return horiz;
    }

    public LinearLayout createLinearLayout() {
        LinearLayout lin = new LinearLayout(getContext());
        lin.setLayoutParams(new CardView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        lin.setOrientation(LinearLayout.HORIZONTAL);

        return lin;
    }

    // Get recipes from file (this will be to populate favorite recipes
    // and liked recipes
    public List<Recipe> getRecipe(Context context, String file, UserJson js) {
        Gson gson = new Gson();
        String ret = js.streamReader(context, file);
        Type listRecipeType = new TypeToken<List<Recipe>>() {}.getType();
        List<Recipe> recipes = gson.fromJson(ret, listRecipeType);
        return recipes;
    }

    public void populateThisWeeksMeals(View root, ViewHelper obj) {
        thisWeeksMeals = root.findViewById(R.id.homeThisWeeksMeals);
        UserJson userJson = new UserJson(getContext());
        List<Recipe> favRecipe = getRecipe(getContext(), "recipesFav.json", userJson);

        if (favRecipe != null) {
            HorizontalScrollView horiz = createHorizontalScroll();
            LinearLayout lin = createLinearLayout();

            thisWeeksMeals.addView(horiz);
            horiz.addView(lin);

            for(int i = 0; i < favRecipe.size(); i++){
                obj.createFullCard(favRecipe.get(i).getName(), 0, favRecipe.get(i).getDifficultyLevel(), lin, favRecipe.get(i).getId(), getActivity(), getContext(), getResources(), getFragmentManager());
            }
        }
    }

    public void populateYourFavorites(View root, ViewHelper obj) {
        yourFavorites = root.findViewById(R.id.homeYourFavorites);
        UserJson userJson = new UserJson(getContext());
        List<Recipe> favRecipe = getRecipe(getContext(), "recipesFav.json", userJson);

        if (favRecipe != null) {
            HorizontalScrollView horiz = createHorizontalScroll();
            LinearLayout lin = createLinearLayout();

            yourFavorites.addView(horiz);
            horiz.addView(lin);

            for(int i = 0; i < favRecipe.size(); i++){
                obj.createFullCard(favRecipe.get(i).getName(), 0, favRecipe.get(i).getDifficultyLevel(), lin, favRecipe.get(i).getId(), getActivity(), getContext(), getResources(), getFragmentManager());
            }
        }
    }
}