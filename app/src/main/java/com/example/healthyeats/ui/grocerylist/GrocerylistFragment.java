package com.example.healthyeats.ui.grocerylist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.healthyeats.R;

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