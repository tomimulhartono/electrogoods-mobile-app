package com.example.electrogoods.ui.sell;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SellViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SellViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragment Explore");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
