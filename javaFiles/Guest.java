package Hotel_Toad;

/**
 * Represents a guest with associated personal details.
 * @author Toad's Taskforce
 * @version 1.0
 * <p>
 * Date of Creation: 28 July 2023
 * </p>
 *
 * This class provides functionalities to manage and retrieve guest details.
 */
public class Guest {

    /** The first name of the guest. */
    private String firstName;
    /** The last name of the guest. */
    private String lastName;
    /** The email address of the guest. */
    private String email;



    /**
     * Constructs a new Guest with the given personal details.
     *
     * @param firstName the first name of the guest.
     * @param lastName  the last name of the guest.
     * @param email     the email address of the guest.
     */
    public Guest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Retrieves the first name of the guest.
     *
     * @return the first name of the guest.
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Retrieves the last name of the guest.
     *
     * @return the last name of the guest.
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * Retrieves the email address of the guest.
     *
     * @return the email address of the guest.
     */
    public String getEmail(){
        return email;
    }

}