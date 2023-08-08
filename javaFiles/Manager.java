package Hotel_Reservation.src;

import java.sql.SQLException;
// Java Manager class
public class Manager {

    // Manager class attributes
    private String userName;

    private  String passWord;

    public void generateReport() throws ClassNotFoundException, SQLException{
        // Create DataBase object
        Database d = new Database();
        //Calls checkCustomerDetails from DataBase class to get details
        d.checkCustomerDetails();
        //Calls roomAvailability from DataBase class to get details
        d.roomAvailability();
        //Calls bookingDetails from DataBase class to get details
        d.bookingDetails();
    }
}
