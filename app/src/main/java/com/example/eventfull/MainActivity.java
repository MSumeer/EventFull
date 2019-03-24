package com.example.eventfull;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        loadFile("Users.txt");
        loadFile("Events.txt");

        Button btnLogin = findViewById(R.id.btnMainLogin);
        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnGuest = findViewById(R.id.btnGuest);


        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent login = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(login);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(register);
            }
        });
        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent main = new Intent(MainActivity.this,GuestActivity.class)
            }
        });

    }
    public void loadFile(String fileName){
        File file = new File(getFilesDir()+"/"+fileName);
        if(!(file.exists())){
            InputStream is = null;
            try {

                is = getAssets().open(fileName);

                InputStreamReader ois = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(ois);
                String line = "";
                StringBuilder sb = new StringBuilder();

                while((line = br.readLine())!=null){
                    sb.append(line).append("\n");
                }

                FileOutputStream fos = openFileOutput(fileName,MODE_PRIVATE);
                fos.write(sb.toString().getBytes());

                is.close();ois.close();br.close();fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
