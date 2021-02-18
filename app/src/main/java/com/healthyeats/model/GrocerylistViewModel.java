package com.healthyeats.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GrocerylistViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GrocerylistViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is grocerylist fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}