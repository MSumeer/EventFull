package com.example.eventfull;

public class Ticket {
    private String section;
    private int eventID,ID ;

    public Ticket(int eventID,String section,int id){
        this.eventID = eventID;
        this.section = section;
        this.ID = id;
    }

    //Setters and Getters
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
