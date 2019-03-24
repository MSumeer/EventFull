package com.example.eventfull;

import android.content.Context;

import java.util.ArrayList;

public class Staff extends User{

    //constructor
    public Staff(String firstName, String lastName, String email,String DOB,String userName, String password,Context context){
        super(firstName,lastName,email,DOB,userName,password,context);


    }

    public boolean addEvent(String type, String venueName, String venueLocation,
                            String name, String date, ArrayList<Integer> ticketPrice,
                            int capacity, int id, Context context){
        Event event = new Event(type,venueLocation,venueName,date,name,ticketPrice,capacity,id,capacity);
        return Registry.getInstance().addEventToDB(event,context);
    }

    public static void rescheduleEvent(Event event){}

    public boolean removeEvent(Event event,Context context){
        return Registry.getInstance().removeEventDB(event,context);
    }

    public static void contactAdmin(){}


}
