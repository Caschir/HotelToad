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
    static void addtoCustomerDetails() throws ClassNotFoundException, SQLException{
        String ftest =  "john";
        String ltest= "smith";
        String etest= "example@yahoo.com";
        int itest = 2;
        String url
            = "jdbc:mysql://hotel-reservation.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
         String query
            = "insert into Customer_Details(ID,First_Name,Last_Name,Email) "+"values (?, ?, ?, ?)"; // query to be run
        Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        
        //Statement st = con.createStatement();
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, itest);
        preparedStmt.setString (2, ftest);
        preparedStmt.setString (3, ltest);
        preparedStmt.setString (4, etest);
        preparedStmt.execute();
        
        //ResultSet rs
          //  = st.executeQuery(query);
        System.out.println("ADDED");
        //rs.next(); 
        //st.close(); // close statement
        con.close(); // close connection   
    }

}
