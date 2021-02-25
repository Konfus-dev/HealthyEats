package com.healthyeats.controller.recipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.healthyeats.R;
import com.healthyeats.controller.searchAndFilter.SearchAndFilter;
import com.healthyeats.model.recipe.Recipe;

public class RecipeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recipe, container, false);
    }

    public static void loadRecipeToRecipeView(int recipeId) {
        SearchAndFilter search = new SearchAndFilter();
        Recipe retrievedRecipe = search.searchById(recipeId);

        System.out.println(retrievedRecipe.getInstructions());
        //populate recipe view with retrieved recipe
    }
}
