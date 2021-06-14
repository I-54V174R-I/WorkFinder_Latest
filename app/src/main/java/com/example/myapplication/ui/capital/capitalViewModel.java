package com.example.myapplication.ui.capital;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class capitalViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public capitalViewModel() {
        mText = new MutableLiveData<>();
        // hacer suma ...

        mText.setValue("tienes disponible para ofrecer: ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
