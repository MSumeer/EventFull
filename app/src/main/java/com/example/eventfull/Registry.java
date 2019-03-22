package com.example.eventfull;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Registry {

    private static Registry obj = null;

    public static Registry getInstance(){
        if(obj == null){
            obj = new Registry();
        }
        return obj;

    }

    private Registry(){}

    public boolean addNewUser(User user){
        return false;
    }
    public boolean removeUser(User user){
        return false;
    }

    //The read() method essentially reads the file Users.txt and return a JsonArray with the data needed

    private JSONArray read(Context context){
        //variables needed for reading the file
        FileInputStream fis;
        BufferedReader br;
        InputStreamReader isr;
        StringBuilder json = new StringBuilder();
        JSONArray jsa = null;
        try {

            fis = context.openFileInput("Users.txt"); //opens the saved file Users.txt and reads in bytes
            isr = new InputStreamReader(fis); //converts bytes to characters
            br = new BufferedReader(isr); //used to increase efficiency of reading characters
            String line;
            while((line = br.readLine())!=null){ //reads each line till the end
                json.append(line).append("\n"); //concatenates the string from file to json variable
            }

        } catch (FileNotFoundException e) { //catch exception
            e.printStackTrace();
        } catch (IOException e) { //catch exception
            e.printStackTrace();
        }
        try {
            jsa = new JSONArray(json.toString()); // converts the json string to a jsonArray
        } catch (JSONException e) { //catch exception
            e.printStackTrace();
        }
        return jsa; //returns jsonArray
    }

    // searches for username within array and returns a jsonObject
    private JSONObject search(String userName, JSONArray jsa){
        JSONObject jso = null;
        for(int i = 0;i<jsa.length();i++){
            try {
                if(jsa.getJSONObject(i).getString("userName").equals(userName)){
                    jso = jsa.getJSONObject(i);
                }

            } catch (JSONException e) { //catch Exception
                e.printStackTrace();
            }
        }

        if (jso != null){
            return jso;
        }
        return null;
    }

    public User getUser(String userName,Context context){
        JSONArray jsa = read(context);
        JSONObject jso = search(userName,jsa);
        User user = null;
        try{
        if(jso!=null){
                switch (jso.getString("type")) {
                    default:
                        Toast.makeText(context, "error", Toast.LENGTH_LONG).show();
                    case "Admin":
                        user = new Admin(Integer.parseInt(jso.getString("id")),
                                jso.getString("firstName"), jso.getString("lastName"),
                                jso.getString("email"), jso.getString("userName"),
                                jso.getString("Password"));
                        break;
                    case "member":
                        user = new Member(Integer.parseInt(jso.getString("id")),
                                jso.getString("firstName"), jso.getString("lastName"),
                                jso.getString("email"), jso.getString("userName"),
                                jso.getString("Password"));
                        break;
                    case "seasonTicketHolder":
                        user = new SeasonTicketHolder(Integer.parseInt(jso.getString("id")),
                                jso.getString("firstName"), jso.getString("lastName"),
                                jso.getString("email"), jso.getString("userName"),
                                jso.getString("Password"));
                        break;
                    case "staff":
                        user = new Staff(Integer.parseInt(jso.getString("id")),
                                jso.getString("firstName"), jso.getString("lastName"),
                                jso.getString("email"), jso.getString("userName"),
                                jso.getString("Password"));
                        break;
                }
            }

            } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
        }

    public boolean addEventToDB(Event event,Context context){
        File file = new File(context.getFilesDir()+"/Events.txt");
        FileWriter fw = new FileWriter(file,true);
        StringBuilder sb = new StringBuilder();
        sb.append("\"")
        fw.write();
    }
    public boolean RemoveEventDB(Event event){
        return false;
    }
    public Event getEvent(String ID){
        return null;
    }
    public boolean relistTicketDB(Ticket ticket){
        return false;
    }
    public Ticket getTicketDB(){
        return null;
    }
    public boolean updateUserDB(User user){
        return false;
    }
    public boolean updateTicketDB(Ticket ticket){
        return false;
    }
}
