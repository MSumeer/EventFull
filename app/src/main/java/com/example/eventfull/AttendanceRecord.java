package com.example.eventfull;

public class AttendanceRecord {

    private int unattendedCount;

    public AttendanceRecord(){
        unattendedCount = 0;
    }

    public static void incrementCount() {}

    public static void resetCount() {}

    public int getCount(){return unattendedCount;}
}
