package com.healthyeats.controller.searchAndFilter;

import com.healthyeats.MainActivity;
import com.healthyeats.model.recipe.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchAndFilter {

    // Returns number of recipes
    public int getNumRecipes() {
        return MainActivity.getRecipeList().size();
    }

    //Search by recipe id (don't ask about how quickly...)
    public Recipe searchById(int id) {
        List<Recipe> recipeList = MainActivity.getRecipeList();
        List<Recipe> searchResults = new ArrayList<Recipe>();
        for (int i = 0; i < recipeList.size(); i++) {
            if (Integer.parseInt(recipeList.get(i).getId()) == id) {
                return recipeList.get(i);
            }
        }
        return null;
    }

    //Search by recipe name (don't ask about how quickly...)
    public List<Recipe> getResultsByName(String userInput) {
        int count = 0;
        List<Recipe> recipeList = MainActivity.getRecipeList();
        List<Recipe> searchResults = new ArrayList<Recipe>();
        for (int i = 0; i < recipeList.size(); i++) {
            if (recipeList.get(i).getName().contains(userInput)) {
                searchResults.add(recipeList.get(i));
                count++;
            }
            if (count == 20) {
                break;
            }
        }
        return searchResults;
    }

    //Search by tags
    public List<Recipe> getResultsByTag(String userInput) {
        int count = 0;
        List<Recipe> recipeList = MainActivity.getRecipeList();
        List<Recipe> searchResults = new ArrayList<Recipe>();
        for (int i = 0; i < recipeList.size(); i++) {
            if (Arrays.asList(recipeList.get(i).getTags()).contains(userInput)) {
                searchResults.add(recipeList.get(i));
                count++;
            }
            if (count == 20) {
                break;
            }
        }
        return searchResults;
    }

    //Sort by A-Z
    private void sortAZ() {
        Collections.sort(MainActivity.getRecipeList(), Recipe.recipeAZComparator);
    }

    //Sort by Z-A
    private void sortZA() {
        Collections.sort(MainActivity.getRecipeList(), Recipe.recipeZAComparator);
    }

    //Sort by calories low-high
    private void sortCalLowHigh() {
        Collections.sort(MainActivity.getRecipeList(), Recipe.recipeLowHighCalComparator);
    }

    //Sort by calories high-low
    private void sortCalHighLow() {
        Collections.sort(MainActivity.getRecipeList(), Recipe.recipeHighLowCalComparator);
    }

}
