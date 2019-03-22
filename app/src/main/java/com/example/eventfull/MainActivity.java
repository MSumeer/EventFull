package com.example.eventfull;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFiles();

        Button btnLogin = findViewById(R.id.btnMainLogin);
        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnGuest = findViewById(R.id.btnGuest);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent a = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(a);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(a);
            }
        });
        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent a = new Intent(MainActivity.this,GuestActivity.class)
            }
        });

    }
    public void loadFiles(){
        File users = getBaseContext().getFileStreamPath("Users.txt");
        if(!(users.exists())){
            InputStream is = null;
            try {

                is = getAssets().open("Users.txt");

                InputStreamReader ois = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(ois);
                String line = "";
                StringBuilder sb = new StringBuilder();
                while((line = br.readLine())!=null){
                    sb.append(line).append("\n");
                }

                FileOutputStream fos = openFileOutput("Users.txt",MODE_PRIVATE);

                fos.write(sb.toString().getBytes());

                is.close();ois.close();br.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
