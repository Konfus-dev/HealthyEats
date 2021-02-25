package com.healthyeats.controller.recipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.healthyeats.R;
import com.healthyeats.controller.searchAndFilter.SearchAndFilter;
import com.healthyeats.model.recipe.Recipe;

public class RecipeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        int id = args.getInt("id", -1);
        System.out.println("TEST " + id);

        View root = inflater.inflate(R.layout.fragment_recipe, container, false);
        getRecipeData(id, root);

        return root;
    }

    // Pass data from cookbook page
    public static RecipeFragment newInstance(int id) {
        RecipeFragment f = new RecipeFragment();
        // Supply id input as an argument.
        Bundle args = new Bundle();
        args.putInt("id", id);
        f.setArguments(args);
        return f;
    }

    public void replaceRecipeData(String difficulty, int servings, int cookTime, String name, View root) {
        TextView diff = (TextView) root.findViewById(R.id.recipeDifficultyText);
        diff.setText(difficulty);

        ImageView diffImg = (ImageView) root.findViewById(R.id.recipeDifficultyImage);
        if (difficulty.equals("Beginner")) {
            diffImg.setImageDrawable(root.getResources().getDrawable(R.drawable.difficultyeasy_icon));
        } else if (difficulty.equals("Intermediate")) {
            diffImg.setImageDrawable(root.getResources().getDrawable(R.drawable.difficultymed_icon));
        } else if (difficulty.equals("Hard")) {
            diffImg.setImageDrawable(root.getResources().getDrawable(R.drawable.difficultyhard_icon));
        }

        TextView serve = (TextView) root.findViewById(R.id.recipeServingSize);
        serve.setText(Integer.toString(servings));

        TextView cook = (TextView) root.findViewById(R.id.recipeCookTime);
        cook.setText(Integer.toString(cookTime));

        TextView recipeName = (TextView) root.findViewById(R.id.recipeNameText);
        recipeName.setText(name);
    }

    public void replaceRecipeNutrition(int calories, int carbs, int protein, int sugar, View root) {
        TextView cal = (TextView) root.findViewById(R.id.caloriesText);
        cal.setText(Integer.toString(calories));

        TextView carb = (TextView) root.findViewById(R.id.CarbText);
        carb.setText(Integer.toString(carbs));

        TextView prot = (TextView) root.findViewById(R.id.proteinText);
        prot.setText(Integer.toString(protein));

        TextView sug = (TextView) root.findViewById(R.id.sugarText);
        sug.setText(Integer.toString(sugar));
    }

    public void populateInstructions(String[] inst, View root) {
        LinearLayout instructions = root.findViewById(R.id.instructionList);
        for (int i = 0; i < inst.length; i++) {
            TextView recipeName = new TextView(getActivity());
            recipeName.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            recipeName.setText("Step " + (i + 1) + " " + inst[i]);
            instructions.addView(recipeName);
        }
    }

    public void populateIngredients(View root) {

    }

    public void getRecipeData(int recipeId, View root) {
        SearchAndFilter search = new SearchAndFilter();
        Recipe retrievedRecipe = search.searchById(recipeId);

        String difficulty = retrievedRecipe.getDifficultyLevel();
        int servings = retrievedRecipe.getServings();
        int cookTime = retrievedRecipe.getCookTime() + retrievedRecipe.getPrepTime() + retrievedRecipe.getWaitTime();
        String name = retrievedRecipe.getName();
        int calories = retrievedRecipe.getCalories();
        int carbs = retrievedRecipe.getCarbs();
        int protein = retrievedRecipe.getProtein();
        int sugar = retrievedRecipe.getSugar();
        String[] instructions = retrievedRecipe.getInstructions();

        replaceRecipeData(difficulty, servings, cookTime, name, root);
        replaceRecipeNutrition(calories, carbs, protein, sugar, root);
        populateInstructions(instructions, root);
    }
}
