package Hotel_Reservation.src;

// Java Reservation class
public class Reservation {

    // Reservation class attributes
    public int numAdults;
    public int numChildren;
    public String checkIn;
    public String checkOut;
    public String roomType;
    public String message;


    // Reservation class constructor
    public Reservation(int numAdults, int numChildren, String checkIn, String checkOut, String roomType,String message){
        this.numAdults = numAdults;
        this.numChildren = numChildren;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomType = roomType;
        this.message = message;
    }

    // Getters for Reservation class
    public int getNumAdults(){
        return numAdults;
    }

    public int getNumChildren(){
        return numChildren;
    }

    public String getCheckIn(){
        return checkIn;
    }

    public String getCheckOut(){
        return checkOut;
    }

    public String getRoomType(){
        return roomType;
    }

    public String getMessage(){
        return roomType;
    }

    // Reservation method for printing out Reservation data
    public String printReservationInfo(){
        return "\nNumber of Adults: "+numAdults+"\nNumber of Children: "+numChildren+"\nCheck-In Date: "+checkIn
                +"\nCheck-Out Date: "+checkOut+"\nRoom Type: "+roomType+"\nMessage: "+message;
    }

}
