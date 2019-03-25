package com.example.eventfull;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class AddEventActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        EditText type = findViewById(R.id.addType);
        EditText venueName = findViewById(R.id.addVenueName);
        EditText capacity = findViewById(R.id.addCapacity);
        EditText location = findViewById(R.id.addLocation);
        EditText date = findViewById(R.id.addDate);
        EditText name = findViewById(R.id.addName);

        Spinner dropdown = findViewById(R.id.spinner1);

        int[] items = new int[20];

        for(int i = 0;i<items.length;i++){
            items[i] = i;
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);



    }
}
