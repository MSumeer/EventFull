package com.example.eventfull;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {
    String[] data;
    SearchView searchView;
    ListView listView;
    User user = null;
    //onCreate() method invoked once the application starts
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity);
        String userName = load();
        user = Registry.getInstance().getUser(userName, getApplicationContext());
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //doMySearch(query);
        }

        JSONArray read = Registry.getInstance().read(getApplicationContext(), "Events.txt");

        try {
            ArrayList<String> items = new ArrayList<String>();
            for (int i = 0; i < read.length(); i++) {
                JSONObject line = read.getJSONObject(i);
                String match = line.optString("name");
                items.add(match);
            }
            ListView mylistview = findViewById(R.id.eventList);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
            mylistview.setAdapter(arrayAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
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



        EditText what = findViewById(R.id.what);
        EditText where = findViewById(R.id.where);
        EditText When = findViewById(R.id.When);


    }





}
