package com.example.eventfull;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.SearchView;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class HomeActivity extends AppCompatActivity {
    User user = null;
    //onCreate() method invoked once the application starts
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity);
        String userName = load();
        user = Registry.getInstance().getUser(userName,getApplicationContext());
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //doMySearch(query);
        }

    }
    public String load(){
        FileInputStream fis;
        String userName="";
        try {
            fis = openFileInput("Objects.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            userName = br.readLine();
            br.close();
            isr.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userName;
    }

    public void searchmethod() {

        JSONArray search= Registry.getInstance().read(getApplicationContext(), "Events.txt");
        EditText what = findViewById(R.id.what);
        EditText where = findViewById(R.id.where);
        EditText When = findViewById(R.id.when);


    }
}
