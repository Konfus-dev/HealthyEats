package com.healthyeats.controller.searchAndFilter;

import com.healthyeats.model.json.JsonReader;
import com.healthyeats.model.recipe.Recipe;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class SearchAndFilter {

    private ArrayList<Recipe> recipeList;
    private JsonReader json;


    public SearchAndFilter() {
        //Import from JSON class
        json = new JsonReader();
        recipeList = json.recipieParser();
    }

    //Search by recipe id (don't ask about how quickly...)
    public Recipe searchById(int id) {
        ArrayList<Recipe> searchResults = new ArrayList<Recipe>();
        for (int i = 0; i < this.recipeList.size(); i++) {
            if (Integer.parseInt(recipeList.get(i).getId()) == id) {
                return recipeList.get(i);
            }
        }
        return null;
    }

    //Search by recipe name (don't ask about how quickly...)
    public ArrayList<Recipe> getResultsByName(String userInput) {
        int count = 0;
        ArrayList<Recipe> searchResults = new ArrayList<Recipe>();
        for (int i = 0; i < this.recipeList.size(); i++) {
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
    public ArrayList<Recipe> getResultsByTag(String userInput) {
        int count = 0;
        ArrayList<Recipe> searchResults = new ArrayList<Recipe>();
        for (int i = 0; i < this.recipeList.size(); i++) {
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
        Collections.sort(this.recipeList, Recipe.recipeAZComparator);
    }

    //Sort by Z-A
    private void sortZA() {
        Collections.sort(this.recipeList, Recipe.recipeZAComparator);
    }

    //Sort by calories low-high
    private void sortCalLowHigh() {
        Collections.sort(this.recipeList, Recipe.recipeLowHighCalComparator);
    }

    //Sort by calories high-low
    private void sortCalHighLow() {
        Collections.sort(this.recipeList, Recipe.recipeHighLowCalComparator);
    }

}
