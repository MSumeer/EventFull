package com.example.eventfull;

import java.util.ArrayList;

public class Event {
    private String type , ID, location , name;
    private ArrayList <Integer> price = new ArrayList<Integer>();
    private int capacity;
    private boolean available;

    //constructor
    public Event(String ID){


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
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
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
}
