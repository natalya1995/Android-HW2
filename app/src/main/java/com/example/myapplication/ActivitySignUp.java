package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitySignUp extends AppCompatActivity {

EditText etLogin;
EditText etPass;
EditText etPassConf;
Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       etLogin=findViewById(R.id.tvLogin);
       etPass=findViewById(R.id.tvPass);
       etPassConf=findViewById(R.id.tvPassConf);
       btnSignUp=findViewById(R.id.signUp);


       btnSignUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String login = etLogin.getText().toString().trim();
               String password = etPass.getText().toString().trim();

            if(etLogin.getText().toString().isEmpty() || etPass.getText().toString().isEmpty() || etPassConf.getText().toString().isEmpty()){
                Toast.makeText(ActivitySignUp.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            }
            else if (!etPass.getText().toString().equals(etPassConf.getText().toString())){
                Toast.makeText(ActivitySignUp.this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
            }
            else if (etPass.getText().toString().length()<8){
                Toast.makeText(ActivitySignUp.this, "Пароль должен быть не менее 8 символов", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent = new Intent(ActivitySignUp.this, ActivityLogIn.class);
                intent.putExtra("login", login);
                intent.putExtra("password", password);
                startActivity(intent);
            }
            }
       });
    }



}