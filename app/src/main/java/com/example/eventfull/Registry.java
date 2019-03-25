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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Registry {

    private static Registry obj = null;

    public static Registry getInstance(){
        if(obj == null){
            obj = new Registry();
        }
        return obj;

    }

    private Registry(){}

    public boolean addNewUser(User user,Context context){

        //Create a JSONObject to store values
        try {
            JSONArray jsa = read(context,"Users.txt");
            JSONObject obj = search(user.getUserName(),jsa);

            if(obj != null){
                return false;
            }
            obj = new JSONObject();
            obj.put("type","member");
            obj.put("id",user.getId());
            obj.put("firstName", user.getFirstName());
            obj.put("lastName", user.getLastName());
            obj.put("email", user.getEmail());
            obj.put("DOB",user.getDOB());
            obj.put("userName", user.getUserName());
            obj.put("password", user.getPassword());
            ArrayList<Integer> a = new ArrayList<Integer>()
            obj.put("tickets",a);

            //Write JSONObject to file
            File file = new File(context.getFilesDir()+"/Users.txt");
            RandomAccessFile raf = new RandomAccessFile(file,"rw");
            String line = "";
            StringBuilder sb = new StringBuilder();
            while((line=raf.readLine())!= null){
                if(line.trim().equals("}")){
                    sb.append("},\n"+obj.toString(8)+"\n");
                }else{
                    sb.append(line+"\n");
                }
            }
            raf.seek(0);
            raf.write(sb.toString().getBytes());

            return true;
        }
        catch(JSONException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean removeUser(User user){
        return false;
    }

    //The read() method essentially reads the file Users.txt and return a JsonArray with the data needed

    public JSONArray read(Context context,String fileName){
        //variables needed for reading the file
        FileInputStream fis = null;
        BufferedReader br = null;
        InputStreamReader isr = null;
        StringBuilder json = new StringBuilder();
        JSONArray jsa = null;
        try {

            fis = context.openFileInput(fileName); //opens the saved file Users.txt and reads in bytes
            isr = new InputStreamReader(fis); //converts bytes to characters
            br = new BufferedReader(isr); //used to increase efficiency of reading characters
            String line;
            while((line = br.readLine())!=null){ //reads each line till the end
                json.append(line).append("\n"); //concatenates the string from file to json variable
            }
            jsa = new JSONArray(json.toString()); // converts the json string to a jsonArray

        } catch (FileNotFoundException e) { //catch exception
            e.printStackTrace();
        } catch (IOException e) { //catch exception
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsa; //returns jsonArray
    }
    public boolean write(Context context, String out, String fileName){
        try{
            FileOutputStream fos = context.openFileOutput(fileName,Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write(out);

            bw.close();
            osw.close();
            fos.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return false;
    }

    // searches for username within array and returns a jsonObject
    public JSONObject search(String userName, JSONArray jsa){
        JSONObject jso = null;
        try {
            for(int i = 0;i<jsa.length();i++){

                if(jsa.getJSONObject(i).getString("userName").equals(userName)){
                    jso = jsa.getJSONObject(i);
                    return jso;
                }

            }
        } catch (JSONException e) { //catch Exception
            e.printStackTrace();
        }
        return null;
    }

    public User getUser(String userName,Context context){
        JSONArray jsa = read(context,"Users.txt");
        JSONObject jso = search(userName,jsa);
        User user = null;
        try{
            if(jso!=null){
                switch (jso.getString("type")) {
                    default:
                        Toast.makeText(context, "error", Toast.LENGTH_LONG).show();
                    case "admin":
                        user = new Admin(jso.getString("firstName"),
                                jso.getString("lastName"), jso.getString("email"),
                                jso.getString("DOB"), jso.getString("userName"),
                                jso.getString("password"),context);
                        break;
                    case "member":
                        user = new Member(jso.getString("firstName"),
                                jso.getString("lastName"), jso.getString("email"),
                                jso.getString("DOB"), jso.getString("userName"),
                                jso.getString("password"),context);
                        break;
                    case "seasonTicketHolder":
                        user = new SeasonTicketHolder(jso.getString("firstName"),
                                jso.getString("lastName"), jso.getString("email"),
                                jso.getString("DOB"), jso.getString("userName"),
                                jso.getString("password"),context);
                        break;
                    case "staff":
                        user = new Staff(jso.getString("firstName"),
                                jso.getString("lastName"), jso.getString("email"),
                                jso.getString("DOB"), jso.getString("userName"),
                                jso.getString("password"),context);
                        break;
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean addEventToDB(Event event,Context context){
        try {
            File file = new File(context.getFilesDir()+"/Events.txt");
            RandomAccessFile raf = new RandomAccessFile(file,"rw");
            StringBuilder sb = new StringBuilder();
            JSONObject jso = new JSONObject();
            jso.put("ID",event.getID());
            jso.put("type",event.getType());
            jso.put("venueName",event.getVenueName());
            jso.put("capacity",event.getCapacity());
            jso.put("location",event.getLocation());
            jso.put("Date",event.getDate());
            jso.put("name",event.getName());
            jso.put("child price",event.getChildPrice());
            jso.put("adult price",event.getAdultPrice());
            jso.put("ticketsRemaining",event.getTicketsRemaining());
            String line;
            while((line =raf.readLine())!=null){
                if(line.trim().equals("}")){
                    sb.append("},\n"+jso.toString(8)+"\n");
                }else{
                    sb.append(line+"\n");
                }
            }
            raf.seek(0);
            raf.write(sb.toString().getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();

        } catch (JSONException e) {
            e.printStackTrace();

        }

        return false;
    }
    public boolean removeEventDB(Event event,Context context){
        StringBuilder sb = new StringBuilder();
        try{
             JSONArray jsa = read(context,"Events.txt");

             sb.append("[\n");
             for(int i = 0;i<jsa.length();i++){
                 if(!(event.getID()==jsa.getJSONObject(i).getInt("id"))){
                     if(i==jsa.length()-1){
                         sb.append(jsa.getJSONObject(i).toString(8)).append("\n]");
                     }else {
                         sb.append(jsa.getJSONObject(i).toString(8)).append(",\n");
                     }
                 }
             }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return write(context,sb.toString(),"Events.txt");
    }
    public Event getEventDB(int ID,Context context){
        Event event = null;
        try{
            FileInputStream fis = context.openFileInput("Events.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String line = "";
            StringBuilder sb = new StringBuilder();
            while((line = br.readLine())!=null){
                sb.append(line+"\n");
            }
            JSONArray jsa = new JSONArray(sb.toString());
            JSONObject jso = searchEvent(ID,jsa);
            if(jso==null){
                Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show();
            }else{
                event = new Event(jso.getInt("ID"),jso.getString("type"),
                        jso.getString("location"),jso.getString("venueName"),
                        jso.getString("Date"),jso.getString("name"),
                        jso.getInt("capacity"), jso.getInt("ticketsRemaining"),
                        jso.getJSONArray("childPrice"),jso.getJSONArray("adultPrice"));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return event;
    }
    public JSONObject searchEvent(int id,JSONArray jsa){
        JSONObject jso;
        for(int i = 0;i<jsa.length();i++){
            try {
                jso = jsa.getJSONObject(i);

            if(jso.getInt("ID")==id){
                return jso;
            }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public boolean addTicketDB(Ticket ticket,Context context,User user){
        try{
            JSONArray jsa = read(context,"Users.txt");
            JSONObject jso = search(user.getUserName(),jsa);
            JSONArray ticketsJsa = jso.getJSONArray("tickets");
            for(int i = 0;i<ticketsJsa.length();i++){
                jsa.getJSONObject(i).put(ticket.getEventID(),ticket);
            }


        }
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
