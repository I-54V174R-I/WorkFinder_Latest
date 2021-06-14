package com.example.myapplication.ui.perfil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class profileViewModel extends ViewModel {
    private MutableLiveData<String> mText;



    public profileViewModel() {
        mText = new MutableLiveData<>();

        mText.setValue("Abigail Lopez");

    }

    public LiveData<String> getText() {
        return mText;
    }
}
