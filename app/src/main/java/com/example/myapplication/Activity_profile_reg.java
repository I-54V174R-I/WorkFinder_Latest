package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.ui.login.LoginActivity;

public class Activity_profile_reg extends AppCompatActivity {

    TextView TextView18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_reg);

        final Button reg_f = findViewById(R.id.button_finreg);
        TextView18 = (TextView) findViewById(R.id.textView18);

        reg_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg_f = new Intent(Activity_profile_reg.this, LoginActivity.class);
                startActivity(reg_f);
                finish();
                }
        });
    }
}