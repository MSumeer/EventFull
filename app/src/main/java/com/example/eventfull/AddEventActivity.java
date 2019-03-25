package com.example.eventfull;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


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
        final EditText etPrice = findViewById(R.id.addPrice);

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
                int price = Integer.parseInt(etPrice.getText().toString().trim());

                String regexDOB = "\\d\\d/\\d\\d/\\d\\d\\d\\d";

                if(type.equals("")||venueName.equals("")||capacity==0||location.equals("")||date.equals("")||name.equals("")){
                    Toast.makeText(getApplicationContext(),"One or more fields left empty",Toast.LENGTH_LONG).show();
                    return;
                }else if(!(date.matches(regexDOB))) {
                    Toast.makeText(getApplicationContext(), "DOB must be in format dd/mm/yyyy", Toast.LENGTH_LONG).show();
                    return;
                }

                Staff staff = (Staff)user;
                boolean complete = staff.addEvent(type,venueName,location,name,date,price,capacity,getApplicationContext());
                if(complete){
                    Toast.makeText(getApplicationContext(),"added Event",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AddEventActivity.this,StaffActivity.class);
                    startActivity(intent);
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

