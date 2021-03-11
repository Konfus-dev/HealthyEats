package com.healthyeats.controller.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.healthyeats.R;
import com.healthyeats.controller.account.AccountFragment;
import com.healthyeats.controller.recipe.RecipeFragment;
import com.healthyeats.model.account.Account;

public class SettingsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        String name = args.getString("name");
        String location = args.getString("location");

        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        populateNameLocation(name, location, root);
        buttonHandler(root);

        return root;
    }

    // Pass data from accounts page
    public static SettingsFragment newInstance(String name, String location) {
        SettingsFragment f = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putString("location", location);
        f.setArguments(args);
        return f;
    }

    // Populates the name and location value with what it displays previously on screen
    public void populateNameLocation(String currName, String currLocation, View root) {
        TextView name = root.findViewById(R.id.settingsName);
        TextView location = root.findViewById(R.id.settingsLocation);

        name.setText(currName);
        location.setText(currLocation);
    }

    public void buttonHandler(View root) {
        Button back = root.findViewById(R.id.settingsBack);
        Button submit = root.findViewById(R.id.settingsSubmit);

        // Button for going back to settings tab
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountFragment obj = new AccountFragment();
                FragmentTransaction fr = getChildFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_settings, obj);
                fr.addToBackStack(null);
                fr.commit();
            }
        });


//        editButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SettingsFragment obj = SettingsFragment.newInstance(name.getText().toString(), location.getText().toString());
//                FragmentTransaction fr = getChildFragmentManager().beginTransaction();
//                fr.replace(R.id.fragment_account, obj);
//                fr.addToBackStack(null);
//                fr.commit();
//            }
//        });
    }
}
