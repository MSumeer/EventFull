package com.example.eventfull;

import java.util.ArrayList;

public class Member extends User {


    private ArrayList <Integer> orderHistory = new ArrayList<>();


    //constructor
    public Member(int id,String firstName, String lastName, String DOB,String email,String billingAddress,String postalCode,String userName, String password){
        super(id,firstName,lastName,DOB,email,billingAddress,postalCode,userName,password);

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
