package Hotel_Reservation.src;

public class Reservation {
    public int numAdults;
    public int numChildren;
    public String checkIn;
    public String checkOut;
    public String roomType;
    public String message;

    void creatReservation(int numAdults,int numChildren, String checkIn, String checkOut,String roomType, String message){
        
        this.numAdults= numAdults;
        this.numChildren= numChildren;
        this.checkIn= checkIn;
        this.checkOut=checkOut;
        this.roomType=roomType;
        this.message=message;


    }
    void getDetails(int numAdults,int numChildren, String checkIn, String checkOut,String roomType, String message){

        this.numAdults= numAdults;
        this.numChildren= numChildren;
        this.checkIn= checkIn;
        this.checkOut=checkOut;
        this.roomType=roomType;
        this.message=message;
        

    }
    
}
