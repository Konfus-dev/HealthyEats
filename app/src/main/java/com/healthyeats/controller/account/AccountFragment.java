package com.healthyeats.controller.account;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.healthyeats.R;
import com.healthyeats.model.account.Account;
import com.healthyeats.model.json.UserJson;
import com.healthyeats.model.viewModels.AccountViewModel;

public class AccountFragment extends Fragment {
    private AccountViewModel accountViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountViewModel =
                new ViewModelProvider(this).get(AccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_account, container, false);
        UserJson user = new UserJson(getContext());

        Account myAccount = user.getAccount(getContext());
        facilitateAccount(root, myAccount, user);

        return root;
    }

    // Get propper id and array for corresponding item
    // then populate value
    public void populateSpinner(View root, Account myAccount, UserJson user, String type) {
        int id = 0;
        int arr = 0;
        String value = "";

        // Switch statement to get corresponding id / arr
        switch (type) {
            case "Notifications":
                id = R.id.spinnerNotifications;
                arr = R.array.notifications_array;
                value = myAccount.getNotifications();
                break;
            case "Language":
                id = R.id.spinnerLanguage;
                arr = R.array.language_array;
                value = myAccount.getLanguage();
                break;
            case "Currency":
                id = R.id.spinnerCurrency;
                arr = R.array.currency_array;
                value = myAccount.getCurrency();
                break;
            case "Measurement":
                id = R.id.spinnerMeasurement;
                arr = R.array.measurement_array;
                value = myAccount.getUnits();
                break;
            default:
                break;
        }

        System.out.println(" CURRENCY " + myAccount.getCurrency());
        Spinner spinner = (Spinner) root.findViewById(id);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                arr, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                myAccount.setNotifications((String) parent.getItemAtPosition(position));
                user.writeToFileAccount(myAccount, getContext());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

    }

    public void facilitateAccount(View root, Account myAccount, UserJson user) {
        populateSpinner(root, myAccount, user, "Notificiations");
        populateSpinner(root, myAccount, user, "Language");
        populateSpinner(root, myAccount, user, "Currency");
        populateSpinner(root, myAccount, user, "Measurement");
    }
}
