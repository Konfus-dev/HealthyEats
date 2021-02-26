package com.healthyeats.model.json;

import com.healthyeats.model.recipe.Recipe;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class JsonReaderWriter
{
    /**
     * loadJSONFromAsses loads the recipe JSON file from the asset folder
     * @param context context of the method
     * @return the jsonString from assets
     */
    private String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("json/loaded-recipes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    /**
     * recipeParse parses the content of the recipe file
     * @param context the context of the method
     * @return a List of recipe's
     */
    public List<Recipe> recipeParser(Context context) {
        String jsonFileString = loadJSONFromAsset(context);
        Gson gson = new Gson();
        Type listRecipeType = new TypeToken<List<Recipe>>() { }.getType();
        List<Recipe> recipes = gson.fromJson(jsonFileString, listRecipeType);
        return recipes;
    }
}