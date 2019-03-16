package com.example.eventfull;

public class Registry {

    private static Registry obj = null;

    public Registry getInstance(){
        if(obj == null){
            obj = new Registry();
        }
        return obj;

    }

    private Registry(){}

    public boolean addNewUser(User user){
        return false;
    }
    public boolean removeUser(User user){
        return false;
    }
    public User getUser(String userName){
        return null;
    }
    public boolean addEventToDB(Event event){
        return false;
    }
    public boolean RemoveEventDB(Event event){
        return false;
    }
    public Event getEvent(String ID){
        return null;
    }
    public boolean relistTicketDB(Ticket ticket){
        return false;
    }
    public Ticket getTicketDB(){
        return null;
    }
    public boolean updateUserDB(User user){
        return false;
    }
    public boolean updateTicketDB(Ticket ticket){
        return false;
    }
}
