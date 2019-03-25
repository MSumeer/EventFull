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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
        final User user = load();
        final EditText etType = findViewById(R.id.addType);
        final EditText etVenueName = findViewById(R.id.addVenueName);
        final EditText etCapacity = findViewById(R.id.addCapacity);
        final EditText etLocation = findViewById(R.id.addLocation);
        final EditText etDate = findViewById(R.id.addDate);
        final EditText etName = findViewById(R.id.addName);
        final EditText etChildPrice = findViewById(R.id.addChildPrice);
        final EditText etAdultPrice = findViewById(R.id.addAdultPrice);

        Button btnAddEvent = findViewById(R.id.btnAdd);

        btnAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = etType.getText().toString().trim();
                String venueName = etVenueName.getText().toString().trim();
                int capacity = Integer.parseInt(etCapacity.getText().toString().trim());
                String location = etLocation.getText().toString().trim();
                String date = etDate.getText().toString().trim();
                String name = etName.getText().toString().trim();
                String childPrice = etChildPrice.getText().toString().trim();
                String adultPrice = etAdultPrice.getText().toString().trim();

                String regexDOB = "\\d\\d/\\d\\d/\\d\\d\\d\\d";
                String regexPrice = "\\d{2},\\d{2},\\d{2}";

                if(type.equals("")||venueName.equals("")||capacity==0||location.equals("")||date.equals("")||name.equals("")||adultPrice.equals("")){
                    Toast.makeText(getApplicationContext(),"One or more fields left empty",Toast.LENGTH_LONG).show();
                    return;
                }else if(!(date.matches(regexDOB))){
                    Toast.makeText(getApplicationContext(),"DOB must be in format dd/mm/yyyy",Toast.LENGTH_LONG).show();
                    return;
                }else if(!(adultPrice.matches(regexPrice))){
                    Toast.makeText(getApplicationContext(),"must have at least 3 prices within child and adult prices",Toast.LENGTH_LONG).show();
                }
                int[] child = new int[3];
                int[] adult = new int[3];

                if(childPrice.equals("")){
                    childPrice = null;
                }else{
                    String[] a = childPrice.split(",");
                    for(int i = 0;i<a.length;i++){
                        child[i] = Integer.parseInt(a[i]);
                    }
                }
                String[] a = adultPrice.split(",");
                for(int i = 0;i<a.length;i++){
                    adult[i]=Integer.parseInt(a[i]);
                }
                Staff staff = (Staff)user;
                boolean complete = staff.addEvent(type,venueName,location,name,date,child,adult,capacity,getApplicationContext());
                if(complete){
                    Toast.makeText(getApplicationContext(),"added Event",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public User load(){
        User user = null;
        try{
            FileInputStream fis = openFileInput("Objects.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String userName = br.readLine();

            user = Registry.getInstance().getUser(userName,getApplicationContext());
            br.close();
            isr.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
