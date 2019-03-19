package com.example.eventfull;

import android.content.Context;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class User implements AllUsers {
    //Variables
    private String firstName,lastName,email,postalCode,userName,password;
    private int incorrectLoginAttempts,id;
    private Calendar DOB = new GregorianCalendar();

    //Constructors
    User(){

    }
    User(int id,String firstName,String lastName, String email, String userName, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.incorrectLoginAttempts = 0;
    }

    //class Functions
    //Login
    public static User login(String userName, String password, Context context,Registry reg, JSONArray jsa){
        User user = reg.getUser(userName,context);
        if(user == null){return null;}
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
    public Calendar getDOB() {
        return DOB;
    }

    public void setDOB(Calendar DOB) {
        this.DOB = DOB;
    }

    //PostalCode
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
