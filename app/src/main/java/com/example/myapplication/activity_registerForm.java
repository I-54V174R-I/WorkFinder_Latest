package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class activity_registerForm extends AppCompatActivity {

    private EditText emailtext;
    private EditText PassText;

    private ProgressDialog progresssDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);

        firebaseAuth = FirebaseAuth.getInstance();

        Button reg_c = findViewById(R.id.buttonsig_reg_card);

        emailtext = findViewById(R.id.Et_Email);
        PassText = findViewById(R.id.Et_password);

        progresssDialog = new ProgressDialog(this);

        reg_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailtext.getText().toString().trim();
                String pass = PassText.getText().toString().trim();

                Intent rec_a = new Intent(activity_registerForm.this, MainActivity.class);
                rec_a.putExtra(MainActivity.usuarioEmail, email);

                if (TextUtils.isEmpty(email)||TextUtils.isEmpty(pass)||pass.length()<=5||(email.contains("@") == false)||pass.equals("12345")==true){
                    Toast.makeText(activity_registerForm.this, "ingresa un email o password valido", Toast.LENGTH_LONG).show();
                    }
                    else{
                        registrarusuario();
                        }
                    }

        });
    }
    private void registrarusuario(){
        String email = emailtext.getText().toString().trim();
        String pass = PassText.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "se debe de ingresar email o email valido",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(pass)&&pass.length()>6){
            Toast.makeText(this, "se debe de ingresar password valido con mayor a 6 caracteres",Toast.LENGTH_LONG).show();
            return;
        }

        progresssDialog.setMessage("realizando Registro en linea");
        progresssDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(activity_registerForm.this, "registro exitoso de cuenta, continue porfavor con el registro de los demas datos", Toast.LENGTH_LONG).show();
                            Intent reg_c = new Intent(activity_registerForm.this, Activity_AddCard.class);

                            Intent rec_a = new Intent(activity_registerForm.this, MainActivity.class);
                            rec_a.putExtra(MainActivity.usuarioEmail, email);

                            final EditText usernameEditText = findViewById(R.id.nombrePersona);
                            String welcome = "bienvenido " +  usernameEditText.getText().toString();
                            Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
                            startActivity(reg_c);
                            finish();
                        }else
                        {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(activity_registerForm.this, "ese usuario ya esta registrado vuelva a intentarlo", Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(activity_registerForm.this, "No se pudo completar el registro, intentelo de nuevo", Toast.LENGTH_LONG).show();
                            }

                        }
                        progresssDialog.dismiss();
                    }
                });
    }

}