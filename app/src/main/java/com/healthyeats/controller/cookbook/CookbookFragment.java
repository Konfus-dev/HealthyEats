package com.healthyeats.controller.cookbook;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.healthyeats.MainActivity;
import com.healthyeats.R;

import com.healthyeats.model.recipe.Recipe;
import com.healthyeats.model.viewModels.CookbookViewModel;
import com.healthyeats.model.viewModels.ViewHelper;

import java.util.Random;

public class CookbookFragment extends Fragment {

    private CookbookViewModel cookbookViewModel;
    LinearLayout trending;
    LinearLayout ourFavs;
    LinearLayout youShouldTry;
    LinearLayout bangForBuck;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cookbookViewModel =
                new ViewModelProvider(this).get(CookbookViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cookbook, container, false);
        ViewHelper obj = new ViewHelper();

        populateTrending(root, obj);
        populateFavs(root, obj);
        populateYouShouldTry(root, obj);
        populateBangForBuck(root, obj);

        return root;
    }


    // Grabs random recipe in database
    public Recipe generateRandomRecipe() {
        Random rand = new Random();
        return MainActivity.getLoadedRecipes().get(rand.nextInt(MainActivity.getLoadedRecipes().size()));
    }

    // Create 5 card views for trending section in cookbook
    public void populateTrending(View root, ViewHelper obj) {
        trending = root.findViewById(R.id.cookBookTrending);

        for (int i = 0; i < 5; i++) {
            com.healthyeats.model.recipe.Recipe rec = generateRandomRecipe();
            obj.createFullCard(rec.getName(), 0, rec.getDifficultyLevel(), trending, rec.getId(), getActivity(), getContext(), getResources(), getFragmentManager());
        }
    }

    // Create 5 card views for our favorites section in cookbook
    public void populateFavs(View root, ViewHelper obj) {
        ourFavs = root.findViewById(R.id.cookBookOurFavorites);

        for (int i = 0; i < 5; i++) {
            com.healthyeats.model.recipe.Recipe rec = generateRandomRecipe();
            obj.createFullCard(rec.getName(), 0, rec.getDifficultyLevel(), ourFavs, rec.getId(), getActivity(), getContext(), getResources(), getFragmentManager());
        }
    }

    // Create 5 card views for you should try section in cookbook
    public void populateYouShouldTry(View root, ViewHelper obj) {
        youShouldTry = root.findViewById(R.id.cookBookYouShouldTry);

        for (int i = 0; i < 5; i++) {
            com.healthyeats.model.recipe.Recipe rec = generateRandomRecipe();
            obj.createFullCard(rec.getName(), 0, rec.getDifficultyLevel(), youShouldTry, rec.getId(), getActivity(), getContext(), getResources(), getFragmentManager());
        }
    }
    
    // Create 5 card views for bang for buck section in cookbook
    public void populateBangForBuck(View root, ViewHelper obj) {
        bangForBuck = root.findViewById(R.id.cookBookBangForYourBuck);

        for (int i = 0; i < 5; i++) {
            com.healthyeats.model.recipe.Recipe rec = generateRandomRecipe();
            obj.createFullCard(rec.getName(), 0, rec.getDifficultyLevel(), bangForBuck, rec.getId(), getActivity(), getContext(), getResources(), getFragmentManager());
        }
    }
}