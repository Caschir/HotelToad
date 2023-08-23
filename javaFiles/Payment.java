package Hotel_Toad;

import org.junit.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Handles the payment processing and bill calculation for guests' hotel stays.
 * @author Toad's Taskforce
 * @version 1.0
 * <p>
 * Date of Creation: 28 July 2023
 * </p>
 *
 * <p>
 * This class leverages the details of a reservation to compute the total cost for a guest's stay,
 * taking into account factors like room type, number of guests, and the duration of the stay.
 * </p>
 */
public class Payment {

    /**
     * Calculates the total bill for the guest's hotel stay based on the details provided in the reservation.
     *
     * @param reservation  the details of the guest's reservation.
     * @return the total bill for the guest's hotel stay.
     * @throws ParseException if there's an issue parsing the check-in or check-out dates.
     */
    public String calculateBill(Reservation reservation) throws ParseException {

        // Determine room price based on room type
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

        // Calculate nightly cost by considering both adults and children.
        // Note: Children are charged at half the adult rate.
        double costPerNight = (reservation.numAdults * roomPrice) + (reservation.numChildren * (roomPrice/2));

        // Parse check-in and check-out dates
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        Date date1 = sdf.parse(reservation.checkIn);
        Date date2 = sdf.parse(reservation.checkOut);

        // Calculate the difference in dates to get the length of stay
        long dateDifferencesMilliseconds = date2.getTime() - date1.getTime();
        long dateDifferencesDays = TimeUnit.MILLISECONDS.toDays(dateDifferencesMilliseconds);
        int stayLength = Math.toIntExact(dateDifferencesDays);

        // Calculate total bill
        bill = costPerNight * stayLength;
        return "\nRoom Price: "+ fmt.format(bill);
    }
}
