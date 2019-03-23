package com.example.eventfull;

import android.content.Context;
import android.widget.Toast;
import org.json.JSONArray;
import java.util.ArrayList;


public abstract class User implements AllUsers {
    //Variables
    private String firstName,lastName,DOB,email,billingAddress,postalCode,userName,password;
    private int incorrectLoginAttempts = 0,id;
    //Constructors
    User(){

    }
    User(int id,String firstName,String lastName,String DOB, String email,String billingAddress,String postalCode,
         String userName, String password){

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.email = email;
        this.billingAddress = billingAddress;
        this.postalCode = postalCode;
        this.userName = userName;
        this.password = password;
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
    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
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

    //billingAddress
    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
}
