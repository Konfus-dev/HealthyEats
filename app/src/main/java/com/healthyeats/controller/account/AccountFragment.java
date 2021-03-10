package com.healthyeats.controller.account;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

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

        // Grabs spinnner
        Spinner spinner = (Spinner) root.findViewById(id);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                arr, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Sets spinner value to value from json
        if (!value.equals("")) {
            int spinnerPosition = adapter.getPosition(value);
            spinner.setSelection(spinnerPosition);
        }

        // Checks if changed
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (type.equals("Notifications")) {
                    myAccount.setNotifications((String) parent.getItemAtPosition(position));
                } else if (type.equals("Language")) {
                    myAccount.setLanguage((String) parent.getItemAtPosition(position));
                } else if (type.equals("Currency")) {
                    myAccount.setCurrency((String) parent.getItemAtPosition(position));
                } else {
                    myAccount.setUnits((String) parent.getItemAtPosition(position));
                }
                user.writeToFileAccount(myAccount, getContext());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

    }

    // Set Seek bars
    public void populateSeekBars(View root, Account myAccount, UserJson user, String type) {
        int id = 0;
        int val = 0;
        int textViewID = 0;

        if (type.equals("HouseHold")) {
            id = R.id.peopleInHouseHold;
            val = myAccount.getHouseholdSize();
            textViewID = R.id.houseHoldText;
        } else if (type.equals("Budget")) {
            id = R.id.weeklyBudget;
            val = myAccount.getWeeklyBudget();
            textViewID = R.id.budgetText;
        }

        SeekBar seek = (SeekBar) root.findViewById(id);
        TextView text = (TextView) root.findViewById(textViewID);

        if (val != 0) {
            seek.setProgress(val);
            if (type.equals("HouseHold")) {
                text.setText(Integer.toString(val));
            } else if (type.equals("Budget")) {
                text.setText("$" + Integer.toString(val));
            }
        }

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seek, int newNum, boolean b) {
                System.out.println("CHANGED PROGRESS?? " + newNum);
                if (type.equals("HouseHold")) {
                    myAccount.setHouseholdSize(newNum);
                    text.setText(Integer.toString(newNum));
                } else if (type.equals("Budget")) {
                    myAccount.setWeeklyBudget(newNum);
                    text.setText("$" + Integer.toString(newNum));
                }

                seek.setProgress(newNum);
                user.writeToFileAccount(myAccount, getContext());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    // Function that will faciliate all account settings
    public void facilitateAccount(View root, Account myAccount, UserJson user) {
        // Populate seek bars
        populateSeekBars(root, myAccount, user, "HouseHold");
        populateSeekBars(root, myAccount, user, "Budget");

        // Facilitates drop down menu choices
        populateSpinner(root, myAccount, user, "Notifications");
        populateSpinner(root, myAccount, user, "Language");
        populateSpinner(root, myAccount, user, "Currency");
        populateSpinner(root, myAccount, user, "Measurement");
    }
}
