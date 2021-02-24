package com.healthyeats.model.json;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.healthyeats.model.recipe.Recipe;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class JsonReader
{

    private String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("our-recipes.json");
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

    public List<Recipe> recipeParser(Context context) {
        String jsonFileString = loadJSONFromAsset(context);
        Gson gson = new Gson();
        Type listRecipeType = new TypeToken<List<Recipe>>() { }.getType();
        List<Recipe> recipes = gson.fromJson(jsonFileString, listRecipeType);
        //System.out.println("------------------------" + recipes.get(0).toString() + "------------------------");
        return recipes;
    }
}