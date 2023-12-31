package Hotel_Reservation.src;

import java.sql.SQLException;

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
     public static Object reserveRoom(Guest guest, String roomType, String checkIn, String checkOut, String email) throws ClassNotFoundException, SQLException{
        for (int i = 0; i < rooms.length; i++){
            if (rooms[i].getRoomType().equalsIgnoreCase(roomType) && rooms[i].isAvailable()){
                
                
                int roomNumber =rooms[i].getRoomNumber();
                
               
                return roomNumber;
            }
        }
        return null;
    }

    // Hotel method for reserving room for Customer
    public void reserveRoom1(Guest guest, String roomType, String checkIn, String checkOut, String email) throws ClassNotFoundException, SQLException{
        for (int i = 0; i < rooms.length; i++){
            if (rooms[i].getRoomType().equalsIgnoreCase(roomType) && rooms[i].isAvailable()){
                rooms[i].availability = false;
                
                int roomNumber =rooms[i].getRoomNumber();
               
                //Calls addtoCustomerDetails from DataBase class to store the infomation
                Database.addtoCustomerDetails(guest.getFirstName() , guest.getLastName(), email, roomNumber);
                //Calls addBooking from DataBase class to store the infomation
                Database.addBooking(roomNumber,checkIn,checkOut);
                //Calls updateRoomAvailability from DataBase class to store the infomations
                Database.updateRoomAvailability(roomNumber);
                return;
            }
        }
        
    }

    // Hotel method for canceling room for Customer
    public void cancelRoom(int roomNumber){
        for (int i = 0; i < rooms.length; i++){
            if (rooms[i].getRoomNumber() == roomNumber) {
                rooms[i].availability = true;
               
                //Calls deleteCustomerDetails from DataBase class to delete in the Database
                Database.deleteCustomerDetails(roomNumber);
                //Calls nowAvailabe from DataBase class to Updates in the Database
                Database.nowAvailabe(roomNumber);
                //Calls deleteBooking from DataBase class to delete in the Database
                Database.deleteBooking(roomNumber);
                return;
            }
        }
       
    }

}
