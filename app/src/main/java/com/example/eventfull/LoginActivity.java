package com.example.eventfull;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONArray;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class LoginActivity extends AppCompatActivity {

    private EditText txtUserName = null;
    private EditText txtPassword = null;
    private JSONArray jsa = null;


    //onCreate() method invoked once the application starts
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        txtUserName = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        Button btnGet = findViewById(R.id.btnLogin);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    //login method verifies the username and password from jsonArray
    public void login() {
        if(txtUserName.getText().toString().equals("")||txtPassword.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"One or more Fields left blank",Toast.LENGTH_LONG).show();
            return;
        }
        User user = User.login(txtUserName.getText().toString(), txtPassword.getText().toString(), getApplicationContext());
        if (user == null) {
            Toast.makeText(getApplicationContext(),"Login Failed userName or password incorrect",Toast.LENGTH_LONG).show();
        } else {
            try {
                FileOutputStream fos = openFileOutput("Objects.txt", MODE_PRIVATE);
                OutputStreamWriter isr = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(isr);

                bw.write(user.getUserName());
                bw.close();
                isr.close();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);

        }
    }


}
