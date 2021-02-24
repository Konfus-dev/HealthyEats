package com.healthyeats.model.json;

import com.healthyeats.model.grocery.GroceryItem;
import com.healthyeats.model.recipe.Recipe;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonReader
{
    public JsonReader(){
    
    }

    public ArrayList<Recipe> recipeParser()
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

//        try (FileReader reader = new FileReader("com/healthyeats/model/json/db-recipes.json")) {
        try (FileReader reader = new FileReader("src/main/com/healthyeats/model/json/db-recipes.json")) {
            Object obj  = jsonParser.parse(reader);
            JSONObject recipeList =  (JSONObject) obj;
            ArrayList<Recipe> recipes =  parseRecipiesObject(recipeList);
            return recipes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Recipe> parseRecipiesObject(JSONObject recipeList)
    {
            ArrayList<Recipe> recipes = new ArrayList<Recipe>();
            for (Object name : recipeList.keySet()) {
               Recipe recipeTemp = new Recipe();
               JSONObject recipe = (JSONObject) recipeList.get(name);
               recipeTemp.setId((String)recipe.get("id"));
               recipeTemp.setName((String) recipe.get("name"));
               recipeTemp.setSource((String) recipe.get("source"));
               recipeTemp.setPrepTime(((Long)recipe.get("preptime")).intValue());
               recipeTemp.setWaitTime(((Long)recipe.get("waittime")).intValue());
               recipeTemp.setCookTime(((Long)recipe.get("cooktime")).intValue());
               recipeTemp.setServings(((Long)recipe.get("servings")).intValue());
               recipeTemp.setComments((String) recipe.get("comments"));
               recipeTemp.setCalories(((Long)recipe.get("calories")).intValue());

               //Remove recipes that don't have calorie info
               if (recipeTemp.getCalories() == 0) {
                   continue;
               }
               recipeTemp.setFat(((Long)recipe.get("fat")).intValue());
               recipeTemp.setSatFat(((Long)recipe.get("satfat")).intValue());
               recipeTemp.setCarbs(((Long)recipe.get("carbs")).intValue());
               recipeTemp.setFiber(((Long)recipe.get("fiber")).intValue());
               recipeTemp.setSugar(((Long)recipe.get("sugar")).intValue());
               recipeTemp.setProtein(((Long)recipe.get("protein")).intValue());
               recipeTemp.setInstructions((String) recipe.get("instructions"));
               JSONArray ingredients = (JSONArray) recipe.get("ingredients");
               GroceryItem[] ingredientsArray = new GroceryItem[ingredients.size()];
               //String[] ingredientsArray = new String[ingredients.size()];
               for(int j = 0; j < ingredientsArray.length; j++){
                   //ingredientsArray[j] = (String)ingredients.get(j);
                   ingredientsArray[j] = (GroceryItem)ingredients.get(j);
               }
               recipeTemp.setIngredients(ingredientsArray);
               JSONArray tags = (JSONArray) recipe.get("tags");
               String[] tagsArray = new String[tags.size()];
               for(int j = 0; j < tagsArray.length; j++){
                   tagsArray[j] = (String)tags.get(j);

               }
               recipeTemp.setTags(tagsArray);
               int level = 1;
               if(ingredientsArray.length > 5) {
                   level++;
               }
               if(recipeTemp.getInstructions().split("\r\n|\r|\n").length > 4){
                   level ++;
               }
               recipeTemp.setDifficultyLevel(level);
               recipes.add(recipeTemp);
            }
        return recipes;
    }
}
