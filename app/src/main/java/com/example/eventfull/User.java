package com.example.eventfull;

public abstract class User {
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String id;
    private int incorrectLoginAttempts;
    private String password;

    User(){

    }
    User(String firstName,String lastName, String email, String userName, String password){
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.incorrectLoginAttempts = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIncorrectLoginAttempts() {
        return incorrectLoginAttempts;
    }

    public void setIncorrectLoginAttempts(int incorrectLoginAttempts) {
        this.incorrectLoginAttempts = incorrectLoginAttempts;
    }
}
