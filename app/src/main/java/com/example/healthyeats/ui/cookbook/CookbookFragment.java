package com.example.healthyeats.ui.cookbook;

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

public class CookbookFragment extends Fragment {

    private CookbookViewModel cookbookViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cookbookViewModel =
                new ViewModelProvider(this).get(CookbookViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cookbook, container, false);

        return root;
    }
}