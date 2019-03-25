package com.example.eventfull;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {
    ArrayAdapter<String> arrayAdapter;
    User user = null;
    ArrayList<Event>arr = new ArrayList<>();
    //onCreate() method invoked once the application starts
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity);
        String userName = load();
        user = Registry.getInstance().getUser(userName, getApplicationContext());
        JSONArray read = Registry.getInstance().read(getApplicationContext(), "Events.txt");
        final EditText theFilter = (EditText) findViewById(R.id.what);
        try {
            ArrayList<String> items = new ArrayList<String>();
            for (int i = 0; i < read.length(); i++) {
                JSONObject line = read.getJSONObject(i);
                String name = line.optString("name");
                items.add(name);
            }
            ListView mylistview = findViewById(R.id.eventList);
            arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
            mylistview.setAdapter(arrayAdapter);
            mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    try {
                        FileOutputStream fos = openFileOutput("event.txt", MODE_PRIVATE);
                        fos.write(arr.get(position).getID());
                        fos.close();


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                });
        } catch (JSONException e) {
            e.printStackTrace();
        }

        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (HomeActivity.this).arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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
