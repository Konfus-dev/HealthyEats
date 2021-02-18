package com.healthyeats.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.healthyeats.R;
import com.healthyeats.model.GrocerylistViewModel;

public class GrocerylistFragment extends Fragment {

    private GrocerylistViewModel groceryListViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        groceryListViewModel =
                new ViewModelProvider(this).get(GrocerylistViewModel.class);
        View root = inflater.inflate(R.layout.fragment_grocerylist, container, false);

        return root;
    }
}