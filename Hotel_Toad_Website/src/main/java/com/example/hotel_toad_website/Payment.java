package com.example.hotel_toad_website;

// imports needed for Payment Class and calculateBill method
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.NumberFormat;

// Java Payment class
public class Payment {

    // Payment class attributes
    //public String name;

    // calculates the Hotel Stay bill for Guest
    public double calculateBill(Guest guest, Reservation reservation) throws ParseException {
        double bill, roomPrice = 0;
        if (reservation.roomType.equalsIgnoreCase("Single")){
            roomPrice = 100.00;
        } else if (reservation.roomType.equalsIgnoreCase("Double")){
            roomPrice = 200.00;
        } else if (reservation.roomType.equalsIgnoreCase("Triple")){
            roomPrice = 420.00;
        } else if (reservation.roomType.equalsIgnoreCase("Suite")){
            roomPrice = 6900.00;
        }

        double costPerNight = (reservation.numAdults * roomPrice) + (reservation.numChildren * (roomPrice/2));

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        Date date1 = sdf.parse(reservation.checkIn);
        Date date2 = sdf.parse(reservation.checkOut);

        long dateDifferencesMilliseconds = date2.getTime() - date1.getTime();

        long dateDifferencesDays = TimeUnit.MILLISECONDS.toDays(dateDifferencesMilliseconds);

        int stayLength = Math.toIntExact(dateDifferencesDays);
        bill = costPerNight * stayLength;
        System.out.println("Room Price: "+fmt.format(bill));
        return bill;
    }
}
