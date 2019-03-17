package com.example.eventfull;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;


public class MainActivity extends AppCompatActivity {

    private EditText txtUserName = (EditText)findViewById(R.id.txtUserName);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGet = (Button) findViewById(R.id.btnLogin);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

   public JSONArray read(){
       FileInputStream fis = null;
       BufferedReader br = null;
       InputStreamReader isr = null;
       String json = "";
       try {
           fis = openFileInput("Users.txt");
           isr = new InputStreamReader(fis);
           br = new BufferedReader(isr);

           String line = "";
           while((line = br.readLine())!=null){
               json+=line;
           }

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       JSONArray jsa = null;
       try {
           jsa = new JSONArray(json);
       } catch (JSONException e) {
           e.printStackTrace();
       }

       return jsa;
   }

   public JSONObject search(String userName, JSONArray jsa){
        JSONObject jso = null;
        for(int i = 0;i<jsa.length();i++){
            try {
                if(jsa.getJSONObject(i).getString("userName").equals(userName)){
                    jso = jsa.getJSONObject(i);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if (jso != null){
            return jso;
        }
        return null
   }

    public void login() throws JSONException {
        JSONArray jsa = read();
        JSONObject jso = search(txtUserName.getText().toString(),jsa);
        User user = null;
        if(jso!=null){
            switch(jso.getString("type")){
                case "Admin":
                    user = new
            }
        }
    }
}
