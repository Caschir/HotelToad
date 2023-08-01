package Hotel_Reservation.src;

public class Room {
   public int roomNumber;

    private String roomType;
    private boolean availability;
    private int price ; 

    void room(int roomNumber,  String roomType, boolean availability , int price){

        this.roomNumber=roomNumber;
        
        this.roomType=roomType;
        this.availability=availability;

       
        
    }
}
}
