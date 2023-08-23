package Hotel_Toad;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * Provides utilities for interacting with the hotel reservation database.
 * @author Toad's Taskforce
 * @version 1.0
 * <p>
 * Date of Creation: 28 July 2023
 * </p>
 */
public class Database {

    /**
     * Retrieves customer details from the database and constructs a table model with this data.
     *
     * @return the constructed table model with customer details.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    public static DefaultTableModel getCustomerDetailsModel() throws ClassNotFoundException, SQLException {
            String url = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation";
            String username = "admin";
            String password = "01NoShotFlip$";
            String query = "select *from Customer_Details";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            DefaultTableModel model = new DefaultTableModel();

            // Add Columns to Model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            // Add Rows to Model
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            st.close();
            con.close();

            return model;
        }

    /**
     * Adds a customer to the database with the provided details.
     *
     * @param firstName The first name of the customer.
     * @param lastName The last name of the customer.
     * @param email The email of the customer.
     * @param number The room number of the customer.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    static void addtoCustomerDetails(String firstName, String lastName ,String email, int number ) throws ClassNotFoundException, SQLException{
        
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
        preparedStmt.setInt (1, number);
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

    /**
     * Deletes customer details associated with the provided room number.
     *
     * @param roomNum The room number of the customer to be deleted.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    static void deleteCustomerDetails(int roomNum) throws ClassNotFoundException, SQLException{
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

    /**
     * Retrieves room availability from the database and constructs a table model with this data.
     *
     * @return the constructed table model with room availability details.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    public static DefaultTableModel getRoomAvailabilityModel() throws ClassNotFoundException, SQLException {
            String url = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation";
            String username = "admin";
            String password = "01NoShotFlip$";
            String query = "select *from Room_Inventory";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            DefaultTableModel model = new DefaultTableModel();

            // Add Columns to Model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            // Add Rows to Model
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            st.close();
            con.close();

            return model;
        }

    /**
     * Updates room availability in the database to 'Not Available' for the specified room number.
     *
     * @param number The room number to be updated.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    static void updateRoomAvailability(int number) throws SQLException, ClassNotFoundException{
        
         String url
            = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String  username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
        String query
            = "update Room_Inventory SET Availability = 'Not Available' where RoomNum = ?  ";
         Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        
        //Statement st = con.createStatement();
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, number);
        preparedStmt.executeUpdate();
        con.close(); // close connection  
    }

    /**
     * Updates room availability in the database to 'Available' for the specified room number.
     *
     * @param roomNum The room number to be updated.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    static void nowAvailable(int roomNum) throws ClassNotFoundException, SQLException{
          String url
            = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
        String query
            = "update Room_Inventory SET Availability =  'Available' where RoomNum =? ";
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

    /**
     * Retrieves booking details from the database and constructs a table model with this data.
     *
     * @return the constructed table model with booking details.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    public static DefaultTableModel bookingDetails() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation";
        String username = "admin";
        String password = "01NoShotFlip$";
        String query = "select *from Booking";
    
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
    
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
    
        DefaultTableModel model = new DefaultTableModel();
    
        // Add Columns to Model
        for (int i = 1; i <= columnCount; i++) {
            model.addColumn(metaData.getColumnName(i));
        }
    
        // Add Rows to Model
        while (rs.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = rs.getObject(i);
            }
            model.addRow(rowData);
        }
    
        st.close();
        con.close();
    
        return model;
    }

    /**
     * Adds a booking in the database with the provided details.
     *
     * @param number The room number associated with the booking.
     * @param startDate The start date of the booking.
     * @param endDate The end date of the booking.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    static void addBooking (int number , String startDate , String endDate) throws ClassNotFoundException, SQLException{
       
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
        preparedStmt.setInt (1, number);
        preparedStmt.setString (2, startDate);
        preparedStmt.setString (3, endDate);
        preparedStmt.execute();
        con.close(); // close connection 

    }

    /**
     * Deletes booking details associated with the provided room number.
     *
     * @param roomNum The room number of the booking to be deleted.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    static void deleteBooking(int roomNum) throws SQLException, ClassNotFoundException{
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
