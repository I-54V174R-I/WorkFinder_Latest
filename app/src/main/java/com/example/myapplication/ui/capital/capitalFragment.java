package com.example.myapplication.ui.capital;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;



public class capitalFragment extends Fragment {

    private capitalViewModel capitalViewModel;
    private com.example.myapplication.ui.capital.capitalViewModel CapitalViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        capitalViewModel =
                new ViewModelProvider(this).get(capitalViewModel.class);
        View root = inflater.inflate(R.layout.fragment_capital, container, false);


        capitalViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

}
