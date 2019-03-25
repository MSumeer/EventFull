package com.example.eventfull;

import android.content.Context;

import java.util.ArrayList;

public class Member extends User {


    private ArrayList <Integer> orderHistory = new ArrayList<>();


    //constructor
    public Member(String firstName, String lastName, String email, String DOB, String userName, String password, Context context){
        super(firstName,lastName,email,DOB,userName,password,context);

    }

    public ArrayList<Integer> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(ArrayList<Integer> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public static void contactStaff() {

    }

    public static void viewHistory(){

    }

    public boolean makePayment(){
        return  true;
    }

    public boolean bookEvent(Event event){
        return true;
    }

    public boolean seasonBooking(Event event){
        return true;
    }
}
