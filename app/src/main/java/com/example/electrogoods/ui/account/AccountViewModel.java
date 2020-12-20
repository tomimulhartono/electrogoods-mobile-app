package com.example.electrogoods.ui.account;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AccountViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public AccountViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragment My Account");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
