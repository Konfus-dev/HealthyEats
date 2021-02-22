package com.healthyeats.controller.Recipe;

import com.healthyeats.model.Database.JsonReader;
import com.healthyeats.model.Recipe.Recipe;
import com.healthyeats.controller.SearchAndFilter;

import java.util.ArrayList;

public static class RecipeLoader {

    private ArrayList<Recipe> recipeList;
    private JsonReader json;

    public static void loadRecipeToRecipeView(int recipeId) {
        SearchAndFilter recipeList = new SearchAndFilter();
        recipeList.searchById();
    }
}
