package Hotel_Toad;

/**
 * Represents a hotel reservation with details about the guests, stay duration, and room type.
 * @author Toad's Taskforce
 * @version 1.0
 * <p>
 * Date of Creation: 28 July 2023
 * </p>
 *
 * <p>
 * This class captures the essential details required to make a reservation in a hotel,
 * including the number of guests, dates of stay, preferred room type, and any additional message or request.
 * </p>
 */
public class Reservation {

    /** The number of adults for the reservation. */
    public int numAdults;
    /** The number of children for the reservation. */
    public int numChildren;
    /** The check-in date for the reservation in a string format. */
    public String checkIn;
    /** The check-out date for the reservation in a string format. */
    public String checkOut;
    /** The type of the room for the reservation, e.g., "single", "double", "suite". */
    public String roomType;
    /** Any additional message or note related to the reservation. */
    public String message;


    /**
     * Constructs a new Hotel_Toad.Reservation with the specified details.
     *
     * @param numAdults    the number of adults.
     * @param numChildren  the number of children.
     * @param checkIn      the check-in date.
     * @param checkOut     the check-out date.
     * @param roomType     the room type.
     * @param message      any additional message or note.
     */
    public Reservation(int numAdults, int numChildren, String checkIn, String checkOut, String roomType,String message){
        this.numAdults = numAdults;
        this.numChildren = numChildren;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomType = roomType;
        this.message = message;
    }

    /**
     * Returns the number of adults for the reservation.
     *
     * @return the number of adults.
     */
    public int getNumAdults(){
        return numAdults;
    }

    /**
     * Returns the number of children for the reservation.
     *
     * @return the number of children.
     */
    public int getNumChildren(){
        return numChildren;
    }

    /**
     * Returns the check-in date for the reservation.
     *
     * @return the check-in date.
     */
    public String getCheckIn(){
        return checkIn;
    }

    /**
     * Returns the check-out date for the reservation.
     *
     * @return the check-out date.
     */
    public String getCheckOut(){
        return checkOut;
    }

    /**
     * Returns the type of the room for the reservation.
     *
     * @return the room type.
     */
    public String getRoomType(){
        return roomType;
    }

    /**
     * Returns any additional message or note related to the reservation.
     *
     * @return the message.
     */
    public String getMessage(){
        return roomType;
    }

}
