package com.example.eventfull;

public class Ticket {
    private String ID;
    private int eventID , seatNo;

    //Setters and Getters
    //ID
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    //EventID
    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    //SeatNo
    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }
}
