package Hotel_Reservation.src;

// Java Hotel class
public class Hotel {

    // Hotel class attributes
    private Room[] rooms;

    // Hotel class constructor
    public Hotel(Room[] rooms){
        this.rooms = rooms;
    }

    
    public void roomInfo(){

    }

    // Hotel method for reserving room for Customer
    public void reserveRoom(Guest guest, String roomType, String checkIn, String checkOut){
        for (int i = 0; i < rooms.length; i++){
            if (rooms[i].getRoomType().equalsIgnoreCase(roomType) && rooms[i].isAvailable()){
                rooms[i].availability = false;
                System.out.println("\nRoom Reservation Successful!");
                System.out.println("Guest: " + guest.getFirstName() + " " + guest.getLastName());
                System.out.println("Room Type: " + roomType);
                System.out.println("Check-in: " + checkIn);
                System.out.println("Check-out: " + checkOut);
                return;
            }
        }
        System.out.println("\nSorry, room of type("+roomType+") is not available");
    }

    // Hotel method for canceling room for Customer
    public void cancelRoom(int roomNumber){
        for (int i = 0; i < rooms.length; i++){
            if (rooms[i].getRoomNumber() == roomNumber) {
                rooms[i].availability = true;
                System.out.println("Room Cancellation Successful!");
                return;
            }
        }
        System.out.println("Room not found.");
    }

}
