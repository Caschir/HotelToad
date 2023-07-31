package Hotel_Reservation.src;

public class Room {
    public int roomNumber;
    public int floorNumber;
    private String roomType;
    private String availability;

    void isAvailability(int roomNumber, int floorNumber, String roomType, String availability){

        this.roomNumber=roomNumber;
        this.floorNumber=floorNumber;
        this.roomType=roomType;
        this.availability=availability;
        
    }
}
