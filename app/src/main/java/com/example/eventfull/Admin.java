package com.example.eventfull;

import android.content.Context;

public class Admin extends User {

    //constructor
    public Admin(String firstName, String lastName, String email, String DOB, String userName, String password, Context context){
        super(firstName,lastName,email,DOB,userName,password,context);
    }

    public static void contactStaff(){}

    public boolean deleteUser(User user){return true;}

    public boolean unblockUser(User user){return true;}

    public boolean blockAccount(User user){return true;}

    public static void checkErrorReport(){}

}
