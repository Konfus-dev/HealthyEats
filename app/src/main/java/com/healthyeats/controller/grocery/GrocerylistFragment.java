package com.healthyeats.controller.grocery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.healthyeats.R;
import com.healthyeats.model.viewModels.GrocerylistViewModel;

public class GrocerylistFragment extends Fragment {

    private GrocerylistViewModel grocerylistViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        grocerylistViewModel =
                new ViewModelProvider(this).get(GrocerylistViewModel.class);
        View root = inflater.inflate(R.layout.fragment_grocerylist, container, false);


        return root;
    }

}