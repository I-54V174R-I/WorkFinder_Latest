package com.example.myapplication.ui.servicio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class nuevoservicioModel extends ViewModel {

    private MutableLiveData<String> mText;

    public nuevoservicioModel() {
        mText = new MutableLiveData<>();
        mText.setValue("ingresa los datos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

