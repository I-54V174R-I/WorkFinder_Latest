package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Configuracion extends AppCompatActivity {
    Button telefono;
    Button cuentas;
    Button correo;
    Button localizacion;
    Button mostrarme;
    private TextView textoSeek;
    private SeekBar miSeek;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        textoSeek = (TextView)findViewById(R.id.txtSalida);
        miSeek = (SeekBar)findViewById(R.id.sbDistancia);

        textoSeek.setText("Distancia máxima: " +miSeek.getProgress() + "KM");
        miSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textoSeek.setText("Distancia máxima: "+ progress + " KM");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mostrarme = (Button)findViewById(R.id.btnMostrarme);
        mostrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarme = new Intent(Configuracion.this, Mostrarme.class);
                startActivity(mostrarme);
            }
        });
        localizacion = (Button)findViewById(R.id.btnLocalizacion);
        localizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent localizacion = new Intent(Configuracion.this, Localizacion.class);
                startActivity(localizacion);
            }
        });
        correo = (Button)findViewById(R.id.btnCorreo);
        correo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent correo = new Intent(Configuracion.this, Correo.class);
                startActivity(correo);
            }
        });
        cuentas = (Button)findViewById(R.id.btnCuentas);
        cuentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cuentas = new Intent(Configuracion.this, Cuentas.class);
                startActivity(cuentas);
            }
        });

        telefono = (Button)findViewById(R.id.btnTelefono);
        telefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telefono = new Intent(Configuracion.this, Num_telefonico.class);
                startActivity(telefono);

            }
        });
    }

}