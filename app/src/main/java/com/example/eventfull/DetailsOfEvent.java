package com.example.eventfull;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class DetailsOfEvent extends AppCompatActivity {
    private User user = null;
    private Event event = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_event);

        user = loadUser();
        event = loadEvent();

        TextView txtTitle = findViewById(R.id.txtTitle);
        TextView txtLocation = findViewById(R.id.txtLocation);
        TextView txtDate = findViewById(R.id.txtDate);
        ImageView img = findViewById(R.id.img);
        TextView noTickets = findViewById(R.id.txtNumberTickets);
        TextView txtseat = findViewById(R.id.txtSeats);
        TextView txtPrice = findViewById(R.id.txtPrice);
        Button btnBook = findViewById(R.id.btnBook);



        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user!=null) {
                    Toast.makeText(getApplicationContext(),"You are not Signed in You must sign in to book",Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(DetailsOfEvent.this, PaymentActivity.class);
                    startActivity(intent);

                }}
        });

    }


    public User loadUser(){
        User user = null;
        try{
            FileInputStream fis = null;
            fis = openFileInput("Objects.txt");

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
    public Event loadEvent(){
        Event event = null;
        try{
            FileInputStream fis = openFileInput("event.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while((line=br.readLine())!=null){
                sb.append(line);
            }

            JSONObject jso = new JSONObject(sb.toString());
            event = new Event(jso.getInt("ID"),jso.getString("type"),
                    jso.getString("location"),jso.getString("venueName"),
                    jso.getString("Date"),jso.getString("name"),
                    jso.getInt("capacity"), jso.getInt("ticketsRemaining"),jso.getInt("price"));
            fis.close();
            isr.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return event;
    }
}
