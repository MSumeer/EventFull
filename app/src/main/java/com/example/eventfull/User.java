package com.example.eventfull;

import android.content.Context;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public abstract class User implements AllUsers {
    //Variables
    private String firstName,lastName,DOB,email,userName,password;
    private int incorrectLoginAttempts = 0,id;
    //Constructors
    User(){

    }
    User(String firstName,String lastName, String email,String DOB,String userName, String password,Context context){
        try {
            JSONArray jsa = Registry.getInstance().read(context, "Users.txt");
            JSONObject jso = Registry.getInstance().search(userName,jsa);
            if(jso == null){
                jso = jsa.getJSONObject(jsa.length()-1);
                this.id = jso.getInt("id");
                this.id++;
            }
            this.id = jso.getInt("id");
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.DOB = DOB;
            this.userName = userName;
            this.password = password;
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //class Functions
    //Login
    public static User login(String userName, String password, Context context){
        User user = Registry.getInstance().getUser(userName,context);
        if(user == null){
            Toast.makeText(context,"null",Toast.LENGTH_LONG).show();
            return null;}
        else if((userName.equals(user.getUserName()))&&(password.equals(user.getPassword()))){
            Toast.makeText(context,"Login Successful",Toast.LENGTH_LONG).show();
            return user;
        }
        return null;
    }

    //reset-Password
    public boolean resetPassword(String password){
        return false;
    }

    //Interface Functions
    public ArrayList searchSports(){
        ArrayList <String> boom = new ArrayList<String>();
        return boom;
    }

    public ArrayList searchConcerts(){
        ArrayList <String> boom = new ArrayList<String>();
        return boom;
    }

    public ArrayList searchTheatres(){
        ArrayList <String> boom = new ArrayList<String>();
        return boom;
    }

    //Getters and setters
    //First-Name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //LastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //DOB
    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    //userName
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Incorrect-Attempts
    public int getIncorrectLoginAttempts() {
        return incorrectLoginAttempts;
    }

    public void setIncorrectLoginAttempts(int incorrectLoginAttempts) {
        this.incorrectLoginAttempts = incorrectLoginAttempts;
    }
}
