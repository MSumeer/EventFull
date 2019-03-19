package com.example.eventfull;

public class AttendanceRecord {

    private int count;

    public AttendanceRecord(){
        count = 0;
    }

    public void incrementCount() {count++;}

    public void resetCount() {count = 0;}

    public int getCount(){return count;}
}
