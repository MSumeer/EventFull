package com.example.eventfull;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class User {
    //Variables
    private String firstName,lastName,email,id,postalCode,userName,password;
    private int incorrectLoginAttempts;
    private Calendar DOB = new GregorianCalendar();

    //Constructors
    User(){

    }
    User(String firstName,String lastName, String email, String userName, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.incorrectLoginAttempts = 0;
    }

    //Functional Methods

    //Login
    public User login(String userName, String password){

        return null;
    }

    //reset-Password
    public boolean resetPassword(String password){
        return false;
    }

    //Generic Object methods

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
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
