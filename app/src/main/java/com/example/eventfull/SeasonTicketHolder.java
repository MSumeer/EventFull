package com.example.eventfull;

import android.content.Context;

public class SeasonTicketHolder extends Member {

    //constructor
    public SeasonTicketHolder(String firstName, String lastName, String email, String DOB, String userName, String password, Context context){
        super(firstName,lastName,email,DOB,userName,password,context);


    }

    public boolean relistTicket(Ticket ticket){return true;}

    public static void viewAttendance(){}

    public boolean renewSeasonTicket(){return true;}

}
