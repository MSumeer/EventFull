package com.example.eventfull;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RelistTicket extends AppCompatActivity {
    private ArrayList<Event> event;
    private ArrayList<Ticket> arr;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relist_ticket);
        load();
        ListView cs = findViewById(R.id.listView);

        CustomAdaptor customAdapter = new CustomAdaptor(getApplicationContext(),event,arr );
        cs.setAdapter(customAdapter);
    }
    public void load(){
        try{
            ArrayList <Ticket> arr = new ArrayList <Ticket>();
            ArrayList <Event> e = new ArrayList <Event>();
            JSONArray jsa = Registry.getInstance().read(getApplicationContext(),"Users.txt");
            int count = 0;
            for(int i = 0;i<jsa.length();i++){
                JSONObject jso = jsa.getJSONObject(i);
                JSONArray jsa1 = jso.getJSONArray("tickets");
                for(int j = 0;j<jsa1.length();j++){
                    JSONObject jso1 = jsa1.getJSONObject(i);
                    Ticket ticket = new Ticket(jso.getInt("eventID"),
                            jso.getString("section"),jso.getInt("ID"));
                    arr.add(count,ticket);
                    count++;
                }
            }
            for(int i = 0;i<arr.size();i++){
                int id = arr.get(i).getEventID();
                event.add(i,Registry.getInstance().getEventDB(id,getApplicationContext()));
            }
            this.arr = arr;
            FileInputStream fis = openFileInput("Objects.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String userName = br.readLine();
            user = Registry.getInstance().getUser(userName,getApplicationContext());
            br.close();
            isr.close();
            fis.close();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
