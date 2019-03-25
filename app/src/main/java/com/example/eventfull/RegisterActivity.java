package com.example.eventfull;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeractivity);

        //Assigning text from the text boxes to variables
        final EditText etFirstName = findViewById(R.id.etFirstName);
        final EditText etLastName = findViewById(R.id.etLastName);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etUsername = findViewById(R.id.etUsername);
        final EditText etPassword = findViewById(R.id.etPassword);
        final EditText etDOb = findViewById(R.id.etDOB);

        //Assigning the register button to a variable
        final Button btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Assign text from text boxes to variables
                String firstName = etFirstName.getText().toString().trim();
                String lastName = etLastName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String DOB = etDOb.getText().toString().trim();

                String regexEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
                String regexDOB = "\\d\\d/\\d\\d/\\d\\d\\d\\d";


                if (firstName.equals("") || lastName.equals("") || email.equals("") || username.equals("") || password.equals("") || DOB.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields left empty", Toast.LENGTH_LONG).show();
                    return;
                } else if (!(email.matches(regexEmail))) {
                    Toast.makeText(getApplicationContext(), "Email invalid", Toast.LENGTH_SHORT).show();
                    return;
                } else if (password.length() < 8) {
                    Toast.makeText(getApplicationContext(), "Password should be 8 characters or longer", Toast.LENGTH_LONG).show();
                    return;
                } else if (!(DOB.matches(regexDOB))) {
                    Toast.makeText(getApplicationContext(), "DOB must be in format dd/mm/yyyy", Toast.LENGTH_LONG).show();
                    return;
                }

                User user = new Member(firstName, lastName, email, DOB, username, password, getApplicationContext());

                if (Registry.getInstance().addNewUser(user, getApplicationContext())) {
                    Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                    Intent main = new Intent(RegisterActivity.this, HomeActivity.class);
                    startActivity(main);
                } else {
                    Toast.makeText(getApplicationContext(), "UserName already exists", Toast.LENGTH_LONG).show();
                }

            }

        });

    }
}
