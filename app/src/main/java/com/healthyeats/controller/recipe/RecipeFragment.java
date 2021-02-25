package com.healthyeats.controller.recipe;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.healthyeats.R;
import com.healthyeats.controller.searchAndFilter.SearchAndFilter;
import com.healthyeats.model.recipe.Ingredient;
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

    public int toDP(float dp) {
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        return (int) (metrics.density * dp + 0.5f);
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

            // Margin
            ViewGroup.MarginLayoutParams layoutParams =
                    (ViewGroup.MarginLayoutParams) recipeName.getLayoutParams();
            layoutParams.setMargins(0, toDP(5), 0, toDP(5));
            recipeName.requestLayout();

            recipeName.setText("Step: " + (i + 1) + " " + inst[i]);
            instructions.addView(recipeName);
        }
    }

    public ImageButton createIngredientButton(View root) {
        //Image Button Creation - Height | Width
        ImageButton ingredButton = new ImageButton(getActivity());
        ingredButton.setLayoutParams(new LinearLayout.LayoutParams(toDP(35), toDP(50)));

        // Margin
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) ingredButton.getLayoutParams();
        layoutParams.setMargins(0, toDP(5), 0, 0);
        ingredButton.requestLayout();

        // Set Scale
        ingredButton.setScaleType(ImageView.ScaleType.FIT_XY);

        ingredButton.setBackgroundColor(Color.parseColor("#F1F9FF"));
        ingredButton.setImageDrawable(root.getResources().getDrawable(R.drawable.addbluebackground_icon));

        return ingredButton;
    }

    public TextView createIngredientText(View root, Ingredient ing) {
        TextView ingredient = new TextView(getActivity());
        ingredient.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ingredient.setGravity(1);

        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) ingredient.getLayoutParams();
        layoutParams.setMargins(toDP(3), toDP(17), 0, toDP(2));
        ingredient.requestLayout();

//        ingredient.setTextSize(toDP(10));

        ingredient.setText("\t" + ing.getAmount() + " " + ing.getMeasurement() + " " + ing.getName());

        return ingredient;
    }

    public void populateIngredients(View root, Ingredient[] ingredient) {
        LinearLayout ingredientList = root.findViewById(R.id.ingredientList);

        for (int i = 0; i < ingredient.length; i++) {
            LinearLayout tempLayout = new LinearLayout(getActivity());
            tempLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            // Margin
            ViewGroup.MarginLayoutParams layoutParams =
                    (ViewGroup.MarginLayoutParams) tempLayout.getLayoutParams();
            layoutParams.setMargins(toDP(15), 0, 0, 0);
            tempLayout.requestLayout();

            //Set horizontal orientation
            tempLayout.setOrientation(LinearLayout.HORIZONTAL);

            ingredientList.addView(tempLayout);
            tempLayout.addView(createIngredientButton((root)));
            tempLayout.addView(createIngredientText(root, ingredient[i]));
        }
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
        Ingredient[] ingredient = retrievedRecipe.getIngredients();

        replaceRecipeData(difficulty, servings, cookTime, name, root);
        replaceRecipeNutrition(calories, carbs, protein, sugar, root);
        populateInstructions(instructions, root);
        populateIngredients(root, ingredient);
    }
}
