package com.healthyeats.model;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class RecipeList {
    private ArrayList<Recipe> recipeList;
    private jsonReader json;


    public RecipeList() {
        //Import from JSON class
        json = new jsonReader();
        recipeList = json.recipieParser();
    }

    //Search by recipe name (don't ask about how quickly...)
    public ArrayList<Recipe> searchByName(String userInput) {
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
    public ArrayList<Recipe> searchByTag(String userInput) {
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
