package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.ui.login.LoginActivity;

public class Activity_AddCard extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__add_card);

        Button reg_perf = findViewById(R.id.buttonsig_perfil);

        reg_perf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg_perf = new Intent(Activity_AddCard.this, Activity_profile_reg.class);
                startActivity(reg_perf);
                finish();
            }
        });
    }
}