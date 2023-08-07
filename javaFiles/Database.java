package Hotel_Reservation.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
     static void checkCustomerDetails() throws ClassNotFoundException, SQLException{
         String url
            = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
        String query
            = "select *from Customer_Details"; // query to be run
        Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        System.out.println(
            "Connection Established successfully");
        Statement st = con.createStatement();
        ResultSet rs
            = st.executeQuery(query); // Execute query
        while(rs.next()){
            int id = rs.getInt("ID");
            String fname
             = rs.getString("First_Name"); // Retrieve name from db
            String lname = rs.getString("Last_Name");
            String email = rs.getString("Email");
 
            System.out.println(id +" "+fname +" "+lname+" "+email);
        } // Print result on console
        st.close(); // close statement
        con.close(); // close connection
       // System.out.println("Connection Closed....");
    }
    static void addtoCustomerDetails(String firstName, String lastName ,String email, int roomNum ) throws ClassNotFoundException, SQLException{
       
        String url
            = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
         String query
            = "insert into Customer_Details(RoomNum,First_Name,Last_Name,Email) "+"values (?, ?, ?, ?)"; // query to be run
        Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        
        //Statement st = con.createStatement();
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, roomNum);
        preparedStmt.setString (2, firstName);
        preparedStmt.setString (3, lastName);
        preparedStmt.setString (4, email);
        preparedStmt.execute();
        
        //ResultSet rs
          //  = st.executeQuery(query);
        //System.out.println("ADDED");
        //rs.next(); 
        //st.close(); // close statement
        con.close(); // close connection   
    }
    void deleteCustomerDetails(int roomNum) throws ClassNotFoundException, SQLException{
         String url
            = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
        String query
            = "DELETE FROM Customer_Details WHERE RoomNum = ?"; // query to be run
        Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, roomNum);
        preparedStmt.executeUpdate();
        con.close(); // close connection  
   }
   
    void roomAvailability() throws ClassNotFoundException, SQLException{
        String url
            = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
        String query
            = "select *from Room_Inventory"; // query to be run
         Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password); 
        Statement st = con.createStatement();
        ResultSet rs
            = st.executeQuery(query); // Execute query
        while(rs.next()){
             int roomNum = rs.getInt("RoomNum");
            String availability
             = rs.getString("Availability"); // Retrieve name from db
            String roomType = rs.getString("Room_Type");
            
            System.out.println(roomNum +" "+availability +" "+roomType);

        }
        st.close(); // close statement
        con.close(); // close connection
    }
    void updateRoomAvailability(int roomNum) throws SQLException, ClassNotFoundException{

         String url
            = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
        String query
            = "update Room_Inventory SET Availability = 'Not Availability' where RoomNum? ";
         Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        
        //Statement st = con.createStatement();
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, roomNum);
        preparedStmt.executeUpdate();
        con.close(); // close connection  
    }
    void nowAvailabe(int roomNum) throws ClassNotFoundException, SQLException{
          String url
            = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
        String query
            = "update Room_Inventory SET Availability =  'Availability' where RoomNum? ";
         Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        
        //Statement st = con.createStatement();
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, roomNum);
        preparedStmt.executeUpdate();
        con.close(); // close connection  
    }
    
    
    void bookingDetails() throws ClassNotFoundException, SQLException{
        String url
            = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
        String query
            = "select *from Booking"; // query to be run
         Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password); 
        Statement st = con.createStatement();
        ResultSet rs
            = st.executeQuery(query); // Execute query
        while (rs.next()){
             int roomNum = rs.getInt("RoomNum");
            String startDate
             = rs.getString("Start_Date"); // Retrieve name from db
            String endDate = rs.getString("End_Date");
            
            System.out.println(roomNum +" "+startDate +" "+endDate);
        }
        st.close(); // close statement
        con.close(); // close connection
    }
    void addBooking (int roomNum , String startDate , String endDate) throws ClassNotFoundException, SQLException{
        String url
            = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
         String query
            = "insert into Booking(RoomNum,Start_Date,End_Date) "+"values (?, ?, ? )"; // query to be run

         Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, roomNum);
        preparedStmt.setString (2, startDate);
        preparedStmt.setString (3, endDate);
        preparedStmt.execute();
        con.close(); // close connection 

    }
    void deleteBooking(int roomNum) throws SQLException, ClassNotFoundException{
         String url
            = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
        String query
            = "DELETE FROM Booking WHERE RoomNum = ?"; // query to be run
        Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, roomNum);
        preparedStmt.executeUpdate();
        con.close(); // close connection 
    }

}
