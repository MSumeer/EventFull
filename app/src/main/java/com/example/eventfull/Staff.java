package com.example.eventfull;

import java.util.ArrayList;

public class Staff extends User{

    //constructor
    public Staff(int id,String firstName, String lastName, String email,String userName, String password){
        super(id,firstName,lastName,email,userName,password);


    }

    public boolean addEvent(String type, String venueName, String venueLocation, ArrayList<Integer> ticketPrice, int capacity){
        Event event = new Event(type,venueLocation,venueName,ticketPrice,capacity,01,true);
        Registry.getInstance().addEventToDB(event);
        return true;
    }

    public static void rescheduleEvent(Event event){}

    public boolean removeEvent(Event event){return true;}

    public static void contactAdmin(){}


}
