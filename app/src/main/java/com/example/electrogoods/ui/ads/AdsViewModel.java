package com.example.electrogoods.ui.ads;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AdsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AdsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragment My Ads");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
