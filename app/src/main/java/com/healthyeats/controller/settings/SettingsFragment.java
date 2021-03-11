package com.healthyeats.controller.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.healthyeats.R;
import com.healthyeats.controller.recipe.RecipeFragment;

public class SettingsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();


        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        return root;
    }

    // Pass data from cookbook page
    public static SettingsFragment newInstance() {
        SettingsFragment f = new SettingsFragment();

        return f;
    }
}
