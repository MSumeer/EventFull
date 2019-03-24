package com.example.eventfull;

public class SeasonTicketHolder extends Member {

    //constructor
    public SeasonTicketHolder(int id,String firstName, String lastName, String DOB,String email,String userName, String password){
        super(id,firstName,lastName,DOB,email,userName,password);


    }

    public boolean relistTicket(Ticket ticket){return true;}

    public static void viewAttendance(){}

    public boolean renewSeasonTicket(){return true;}

}
