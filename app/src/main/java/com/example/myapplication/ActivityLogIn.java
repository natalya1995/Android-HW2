package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityLogIn extends AppCompatActivity {

    EditText edLogin;
    EditText edPass;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edLogin = findViewById(R.id.etLogin);
        edPass = findViewById(R.id.etPass);
        btnSignIn = findViewById(R.id.signIn);

        String savedLogin = getIntent().getStringExtra("login");
        String savedPassword = getIntent().getStringExtra("password");
        edLogin.setText(savedLogin);
        edPass.setText(savedPassword);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edLogin.getText().toString().isEmpty() || edPass.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityLogIn.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                } else if (!edLogin.getText().toString().equals(savedLogin) || !edPass.getText().toString().equals(savedPassword)) {
                    Toast.makeText(ActivityLogIn.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ActivityLogIn.this, MainActivity.class);
                    startActivity(intent);
                }

            }

        });

    }

}


