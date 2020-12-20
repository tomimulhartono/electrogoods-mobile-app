package com.example.electrogoods.ui.chat;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChatViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ChatViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragment Chat");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
