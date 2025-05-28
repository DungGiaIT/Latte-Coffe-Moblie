package com.project.cafeshopapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText codeInput;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        codeInput = findViewById(R.id.codeInput);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(v -> {
            String code = codeInput.getText().toString().trim();
            if (code.equals("1234")) {
                startActivity(new Intent(this, TableActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Mã nhân viên sai!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}