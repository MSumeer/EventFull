package com.example.eventfull;

public class Admin extends User {

    //constructor
    public Admin(int id,String firstName, String lastName, String DOB,String email,String billingAddress,String postalCode,String userName, String password){
        super(id,firstName,lastName,DOB,email,billingAddress,postalCode,userName,password);
    }

    public static void contactStaff(){}

    public boolean deleteUser(User user){return true;}

    public boolean unblockUser(User user){return true;}

    public boolean blockAccount(User user){return true;}

    public static void checkErrorReport(){}

}
