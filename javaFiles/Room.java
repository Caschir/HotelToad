package Hotel_Reservation.src;

// Java Room class
public class Room {

    // Room class attributes
    public int roomNumber;
    private String roomType;
    private boolean availability;
    private int price;

    // Room class constructor
    public Room(int roomNumber, String roomType, boolean availability, int price){

        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.availability = availability;
        this.price = price;

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

    public int getPrice(){
        return price;
    }

}
