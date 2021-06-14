package com.example.myapplication.ui.servicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Activity_profile_reg;
import com.example.myapplication.R;
import com.example.myapplication.mapa;

public class nuevoservicioFragment extends Fragment {

    private nuevoservicioModel nuevoservicioModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        nuevoservicioModel=
                new ViewModelProvider(this).get(nuevoservicioModel.class);
        View root = inflater.inflate(R.layout.fragment_nuevoservicio, container, false);
        final TextView textView = root.findViewById(R.id.text_nuevoservicio);

        final Button button = root.findViewById(R.id.button_conti);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent button;
                button = new Intent(getActivity(), mapa.class);
                startActivity(button);
                getActivity().finish();
            }

        });

        nuevoservicioModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) { textView.setText(s); }
        });
        return root;
        
    }
}