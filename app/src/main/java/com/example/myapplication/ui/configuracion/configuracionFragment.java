package com.example.myapplication.ui.configuracion;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.ui.capital.capitalViewModel;

public class configuracionFragment extends Fragment {

    private ConfiguracionViewModel mViewModel;

    private com.example.myapplication.ui.configuracion.ConfiguracionViewModel ConfiguracionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ConfiguracionViewModel=
                new ViewModelProvider(this).get(ConfiguracionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_configuration, container, false);
        final TextView textView = root.findViewById(R.id.text_configuration);
        ConfiguracionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}