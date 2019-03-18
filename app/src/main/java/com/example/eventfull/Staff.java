package com.example.eventfull;

import java.util.ArrayList;

public class Staff extends User{

    //constructor
    public Staff(int id,String firstName, String lastName, String email,String userName, String password){
        super(id,firstName,lastName,email,userName,password);


    }

    public boolean addEvent(String eventType, String venueName, String venueLocation, ArrayList<String> ticketPrice, int capacity){
        return true;
    }

    public static void rescheduleEvent(Event event){}

    public boolean removeEvent(Event event){return true;}

    public static void contactAdmin(){}


}
