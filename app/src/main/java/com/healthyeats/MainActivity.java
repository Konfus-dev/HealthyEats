package com.healthyeats;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.healthyeats.model.grocery.GroceryItem;
import com.healthyeats.model.json.JsonReaderWriter;
import com.healthyeats.model.json.UserJson;
import com.healthyeats.model.recipe.Ingredient;
import com.healthyeats.model.recipe.Recipe;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<Recipe> loadedRecipes;
    private static List<Recipe> favoriteRecipes;
    private static List<GroceryItem> groceryList;
    private JsonReaderWriter json;

    public static List<Recipe> getLoadedRecipes() {
        return loadedRecipes;
    }
    //Todo: make update affect jsonFile
    public static void updateLoadedRecipes(List<Recipe> update) { loadedRecipes = update; }

    public static List<Recipe> getFavoriteRecipes() { return favoriteRecipes; }
    //Todo: make update affect jsonFile
    public static void updateFavoriteRecipes(List<Recipe> update) { favoriteRecipes = update; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_cookbook, R.id.navigation_grocerylist, R.id.navigation_account)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //Import from JSON class
        json = new JsonReaderWriter();
        loadedRecipes = json.recipeParser(getApplicationContext());
        UserJson userJson = new UserJson(getApplicationContext());
        Ingredient ingredient =new Ingredient();
        ingredient.setAmount("5");
        ingredient.setMeasurement("cups");
        ingredient.setName("apple");
        String[] instructions = new String[]{"just try"};
        Recipe recipe = new Recipe(1, "temp", "nowhere", 5, 10,
        4, 1, "NA",3, 2, 1,5,
        2, 1, 3, "Hard", instructions,
                new Ingredient[] {ingredient}, new String[]{"apple"});
//        userJson.writeToFile( recipe, getApplicationContext());
//        userJson.deleteFromFile(recipe,getApplicationContext());
            //testing
//        System.out.println(recipeList.get(0).toString());
    }

    //Creating hard coded data on grocery list (Just to test)
    private void prepareGroceryList() {
        GroceryItem item = new GroceryItem("Cheese", "cheese.jpg", 5, 4.99);
        groceryList.add(item);
        item = new GroceryItem("Apple", "apple.jpg", 3, 2.99);
        groceryList.add(item);
        item = new GroceryItem("Artichoke", "artichoke.jpg", 2, 3.99);
        groceryList.add(item);
        item = new GroceryItem("Arugula", "arugula.jpg", 3, 2.00);
        groceryList.add(item);
        item = new GroceryItem("Crab", "crab.jpg", 2, 20.99);
        groceryList.add(item);
        item = new GroceryItem("Zucchini", "zucchini.jpg", 1, 3.99);
        groceryList.add(item);
        item = new GroceryItem("Licorice", "licorice.jpg", 50, 0.50);
        groceryList.add(item);
    }

}