package com.example.hotel_toad_website;

// Java Room class
public class Room {

    // Room class attributes
    public int roomNumber;
    private String roomType;
    public boolean availability;

    // Room class constructor
    public Room(int roomNumber, String roomType, boolean availability){

        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.availability = availability;

    }

    // Getters for Room class
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isAvailable(){
        return availability;
    }

}
