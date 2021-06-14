package com.example.myapplication.ui.configuracion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConfiguracionViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ConfiguracionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("información de contacto");
    }

    public LiveData<String> getText() {
        return mText;
    }
}