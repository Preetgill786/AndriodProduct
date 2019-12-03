package com.example.productapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etUserName, etPassword;
    Button btnLogIn;
    String[] custName = {"Saman", "Akash", "Preet", "Dharm"};
    String[] custPass = {"Saman", "Akash", "Preet", "Dharm"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName = findViewById(R.id.UserName);
        etPassword = findViewById(R.id.password);
        btnLogIn = findViewById(R.id.login);

        btnLogIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String user = etUserName.getText().toString();
        String pass = etPassword.getText().toString();
        if (user.equals("saman") && pass.equals("saman") || user.equals("Akash") && pass.equals("Akash") || user.equals("Preet") && pass.equals("Preet") ||
                user.equals("Dharm") && pass.equals("Dharm")) {

            Intent act = new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(act);
        } else
            Toast.makeText(getApplicationContext(), "Invalid user name or password", Toast.LENGTH_LONG).show();
    }
}