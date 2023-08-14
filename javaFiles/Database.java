package Hotel_Reservation.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
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
    void updateRoomAvailability(int roomNum) throws SQLException, ClassNotFoundException{

         String url
            = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
        String query
            = "update Room_Inventory SET Availability = 'Not Availability' where RoomNum = ? ";
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
            = "update Room_Inventory SET Availability =  'Availability' where RoomNum = ? ";
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
