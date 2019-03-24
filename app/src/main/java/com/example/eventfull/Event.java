package com.example.eventfull;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class Event {
    private String type , location ,venueName,date, name;
    private ArrayList <Integer> price;
    private int capacity,ID,ticketsRemaining;
    private boolean available;

    //constructor
    public Event(String type, String location, String venueName, String date,
                 String name, JSONArray jsa, int capacity, int ID,
                 int ticketsRemaining){
        this.type = type;
        this.location = location;
        this.venueName = venueName;
        this.date = date;
        this.name = name;
        this.capacity = capacity;
        this.ID = ID;
        this.ticketsRemaining = ticketsRemaining;
        price = new ArrayList<Integer>();
        for(int i = 0;i<jsa.length();i++){
            try {
                price.add(jsa.getInt(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public Event(String type, String location, String venueName, String date,
                 String name, ArrayList <Integer> price, int capacity, int ID,
                 int ticketsRemaining){
        this.type = type;
        this.location = location;
        this.venueName = venueName;
        this.date = date;
        this.name = name;
        this.capacity = capacity;
        this.ID = ID;
        this.ticketsRemaining = ticketsRemaining;
        this.price = price;

    }

    //Class Methods
    public int increaseCapacity(int num){
        return capacity+=num;
    }
    public int decreaseCapacity(int num){
        return capacity-=num;
    }

    //Setters and Getters
    //Type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //ID
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    //Location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Price
    public ArrayList<Integer> getPrice() {
        return price;
    }

    public void setPrice(ArrayList<Integer> price) {
        this.price = price;
    }

    //Capacity
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //Available
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    //TicketsRemaining
    public int getTicketsRemaining() {
        return ticketsRemaining;
    }

    public void setTicketsRemaining(int ticketsRemaining) {
        this.ticketsRemaining = ticketsRemaining;
    }

    //VenueName
    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    //Date
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
