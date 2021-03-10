package com.healthyeats.controller.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.healthyeats.R;
import com.healthyeats.model.viewModels.AccountViewModel;

public class AccountFragment extends Fragment {
    private AccountViewModel accountViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountViewModel =
                new ViewModelProvider(this).get(AccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_account, container, false);
        populateSpinner(root);
        
        return root;
    }

    public void populateSpinner(View root) {
        Spinner notificationSpinner = (Spinner) root.findViewById(R.id.spinnerNotifications);
        ArrayAdapter<CharSequence> adapterNotif = ArrayAdapter.createFromResource(getContext(),
                R.array.notifications_array, android.R.layout.simple_spinner_item);
        adapterNotif.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        notificationSpinner.setAdapter(adapterNotif);

        Spinner languageSpinner = (Spinner) root.findViewById(R.id.spinnerLanguage);
        ArrayAdapter<CharSequence> adapterLanguage = ArrayAdapter.createFromResource(getContext(),
                R.array.language_array, android.R.layout.simple_spinner_item);
        adapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapterLanguage);

        Spinner currencySpinner = (Spinner) root.findViewById(R.id.spinnerCurrency);
        ArrayAdapter<CharSequence> adapterCurrency = ArrayAdapter.createFromResource(getContext(),
                R.array.currency_array, android.R.layout.simple_spinner_item);
        adapterCurrency.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(adapterCurrency);

        Spinner measurementSpinner = (Spinner) root.findViewById(R.id.spinnerMeasurement);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(getContext(),
                R.array.measurement_array, android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        measurementSpinner.setAdapter(adapterSpinner);
    }
}
