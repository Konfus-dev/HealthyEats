package com.healthyeats.controller.recipe;

import com.healthyeats.controller.searchAndFilter.SearchAndFilter;
import com.healthyeats.model.recipe.Recipe;

public class RecipeLoader {

    public static void loadRecipeToRecipeView(int recipeId) {
        SearchAndFilter search = new SearchAndFilter();
        Recipe retrievedRecipe = search.searchById(recipeId);

        //populate recipe view with retrieved recipe
    }
}
