package Hotel_Toad;

import java.sql.SQLException;


/**
 * Represents a manager in the system.
 * @author Toad's Taskforce
 * @version 1.0
 * <p>
 * Date of Creation: 28 July 2023
 * </p>
 *
 * <p>
 * This class is responsible for handling managerial operations, which includes generating reports.
 * </p>
 */
public class Manager {
    /**
     * The username used for manager authentication or identification.
     */
    private String userName;
    /**
     * The password used for manager authentication.
     */
    private  String passWord;

    /**
     * Generates a report based on the data from the database.
     *
     * <p>
     * This method interfaces with the {@link Database} class to fetch data
     * and generate a report. Any specifics about the report format or content
     * should be documented here.
     * </p>
     *
     * @throws ClassNotFoundException if the database driver class is not found.
     * @throws SQLException           if there's any error while interfacing with the database.
     */
    public void generateReport() throws ClassNotFoundException, SQLException{
        // Create DataBase object
        Database d = new Database();

    }
}
