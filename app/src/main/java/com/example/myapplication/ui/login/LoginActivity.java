package com.example.myapplication.ui.login;

import androidx.annotation.NonNull;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.activity_registerForm;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class LoginActivity extends AppCompatActivity {


    private EditText usernameEditText ;
    private EditText passwordEditText ;

    private ProgressDialog progresssDialog;

    private FirebaseAuth firebaseAuth;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        //splash screen
        setTheme(R.style.SplashTheme);

        super.onCreate(savedInstanceState);

        setTheme(R.style.Theme_MyApplication);
        setTheme(R.style.Theme_MyApplication_NoActionBar);

        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);

        progresssDialog = new ProgressDialog(this);


        final Button loginButton = findViewById(R.id.login);

        final Button registers = findViewById(R.id.but_reg);

        firebaseAuth = FirebaseAuth.getInstance();



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = usernameEditText.getText().toString().trim();
                String pass = passwordEditText.getText().toString().trim();

                if (TextUtils.isEmpty(email)||TextUtils.isEmpty(pass)||pass.length()<=5||(email.contains("@") == false)||pass.equals("12345")==true){
                    Toast.makeText(LoginActivity.this, "ingresa un email o password valido", Toast.LENGTH_LONG).show();
                }
                else{
                    loguearUsuario();
                }
            }
        });

        registers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registers = new Intent(LoginActivity.this, activity_registerForm.class);
                startActivity(registers);
                finish();
            }
        });
    }

    private void loguearUsuario(){
        String email = usernameEditText.getText().toString().trim();
        String pass = passwordEditText.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "se debe de ingresar email o email valido",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(pass)&&pass.length()>6){
            Toast.makeText(this, "se debe de ingresar password valido con mayor a 6 caracteres",Toast.LENGTH_LONG).show();
            return;
        }

        progresssDialog.setMessage("realizando consulta en linea...");
        progresssDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "inicio de sesión exitoso", Toast.LENGTH_LONG).show();
                            Intent reg_c = new Intent(LoginActivity.this, MainActivity.class);
                            reg_c.putExtra(MainActivity.usuarioEmail, email);
                            String welcome = "bienvenido!";
                            Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
                            startActivity(reg_c);
                            finish();
                        }else
                        {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException||task.getException() instanceof FirebaseAuthInvalidCredentialsException){
                                Toast.makeText(LoginActivity.this, "ese usuario o contraseña es incorrecto, o su cuenta a sido inhabilitada, vuelva a intentarlo", Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(LoginActivity.this, "No se pudo completar, vuelva a intentarlo mas tarde", Toast.LENGTH_LONG).show();
                            }

                        }
                        progresssDialog.dismiss();
                    }
                });
    }

}