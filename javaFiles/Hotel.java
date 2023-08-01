package Hotel_Reservation.src;

public class Hotel {
    private Room [] rooms;

    public Hotel(Room[] rooms2) {
        this.rooms = rooms2;
        
    }

    public void roomInfo(int roomInventory){
        this.roomInventory=roomInventory;

    }
    void reserveRoom(int roomInventory){
        this.roomInventory=roomInventory;

    }
    void cancelRoom(int roomInventory){
        this.roomInventory=roomInventory;
    }

}
