package com.healthyeats.controller.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.healthyeats.R;
import com.healthyeats.model.viewModels.HomeViewModel;
import com.healthyeats.model.viewModels.ViewHelper;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    LinearLayout thisWeeksMeals;
    LinearLayout yourFavorites;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ViewHelper obj = new ViewHelper();

        return root;
    }

    public void populateThisWeeksMeals(View root, ViewHelper obj) {
        //Get list of This Weeks Meals
//        thisweeksMeals = root.findViewById(R.id.w)
    }

    public void populateYourFavorites(View root, ViewHelper obj) {
        //Get list of Your Favorites
    }
}