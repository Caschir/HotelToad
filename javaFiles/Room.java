package Hotel_Toad;

/**
 * Represents a Hotel_Toad.Room with a room number, room type, and availability status.
 * @author Toad's Taskforce
 * @version 1.0
 * <p>
 * Date of Creation: 28 July 2023
 * </p>
 *
 * <p>
 * This class provides a structure for managing and querying information related
 * to individual rooms in a hotel or similar establishment.
 * </p>
 */
public class Room {

    /** The room number. */
    public int roomNumber;
    /** The type of the room, e.g., "single", "double", "suite". */
    private String roomType;
    /** Indicates whether the room is currently available. */
    public boolean availability;

    /**
     * Constructs a new Hotel_Toad.Room with the specified room number, room type, and availability.
     *
     * @param roomNumber  the room's number.
     * @param roomType    the room's type.
     * @param availability whether the room is available.
     */
    public Room(int roomNumber, String roomType, boolean availability){

        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.availability = availability;

    }

    /**
     * Returns the room number.
     *
     * @return the room number.
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Returns the type of the room.
     *
     * @return the room type.
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Checks if the room is available.
     *
     * @return true if the room is available, false otherwise.
     */
    public boolean isAvailable(){
        return availability;
    }

}
