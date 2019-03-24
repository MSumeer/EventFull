package com.example.eventfull;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeractivity);

        //Assigning text from the text boxes to variables
        final EditText etFirstName = findViewById(R.id.etFirstName);
        final EditText etLastName = findViewById(R.id.etLastName);
        final EditText etDOB = findViewById(R.id.etDOB);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etBillingAddress = findViewById(R.id.etBillingAddress);
        final EditText etPostalCode = findViewById(R.id.etPostalCode);
        final EditText etUsername = findViewById(R.id.etUsername);
        final EditText etPassword = findViewById(R.id.etPassword);

        //Assigning the register button to a variable
        final Button btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Assign text from text boxes to variables
                String firstName = etFirstName.getText().toString().trim();
                String lastName = etLastName.getText().toString().trim();
                String DOB = etDOB.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String billingAddress = etBillingAddress.getText().toString().trim();
                String postalCode = etPostalCode.getText().toString().trim();
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                User user = new Member(1,firstName,lastName,DOB,email,username,password);
                if(Registry.getInstance().addNewUser(user,getApplicationContext())){
                    Toast.makeText(getApplicationContext(),"Registered",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Registration Failed",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
