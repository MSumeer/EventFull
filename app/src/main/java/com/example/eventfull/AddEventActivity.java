package com.example.eventfull;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AddEventActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        final EditText ettype = findViewById(R.id.addType);
        final EditText etvenueName = findViewById(R.id.addVenueName);
        final EditText etcapacity = findViewById(R.id.addCapacity);
        final EditText etlocation = findViewById(R.id.addLocation);
        final EditText etdate = findViewById(R.id.addDate);
        final EditText etname = findViewById(R.id.addName);

        Button btnAddEvent = findViewById(R.id.btnAdd);

        btnAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = ettype.getText().toString().trim();
                String venueName = etvenueName.getText().toString().trim();
                int capacity = Integer.parseInt(etcapacity.getText().toString().trim());
                String location = etlocation.getText().toString().trim();
                String date = etdate.getText().toString().trim();
                String name = etname.getText().toString().trim();

                String regexDOB = "\\d\\d/\\d\\d/\\d\\d\\d\\d";

                if(type.equals("")||venueName.equals("")||capacity==0||location.equals("")||date.equals("")||name.equals("")){
                    Toast.makeText(getApplicationContext(),"One or more fields left empty",Toast.LENGTH_LONG).show();
                    return;
                }else if(!(date.matches(regexDOB))){
                    Toast.makeText(getApplicationContext(),"DOB must be in format dd/mm/yyyy",Toast.LENGTH_LONG).show();
                    return;
                }
                Event event = new Event(type,location,venueName,date,name,capacity,capacity,getApplicationContext());
                Registry.getInstance().addEventToDB(event,getApplicationContext());
            }
        });

    }
}
