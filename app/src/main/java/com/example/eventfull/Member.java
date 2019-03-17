package com.example.eventfull;

import java.util.ArrayList;

public class Member extends User {


    private ArrayList <Integer> orderhistory = new ArrayList<>();


    //constructor
    public Member(){


    }


    public static void ContactStaff() {

    }

    public void getOrderHistory(ArrayList<Integer> orderhistory) {
        this.orderhistory = orderhistory;
    }


    public static void viewHistory(){

    }

    public boolean makePayment(){
        return  true;
    }

    public boolean bookEvent(Event event){
        return true;
    }

    public boolean makeSeasonBooking(Event event){
        return true;
    }
}
