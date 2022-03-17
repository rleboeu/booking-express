/**
 * Class for Booking Agency, adding/removing from agency
 * @author Andrew Garcia
 */
package express; 
import java.util.*;

public class BookingAgency {
    String name;
    String AirportCode;
    ArrayList<BookableEntity> bookings = new ArrayList<BookableEntity>();
    
/**
 * Contructor for booking Agency
 * @param name name of booking agency
 * @param AirportCode airport code 
 * @param bookings bookings in agency
 */
    public BookingAgency(String name, String AirportCode, ArrayList<BookableEntity> bookings) {
        this.name = name;
        this.AirportCode = AirportCode;
        this.bookings = bookings;
    }
/**
 * Contructor for booking agency
 * @param name name of agency 
 */
    public BookingAgency(String name) {
        this.name = name;
    }
/**
 * Adds booking to booking agency
 * @param booking bookings in list
 */
    public void addBooking(BookableEntity booking) {
        bookings.add(booking);
    }
/**
 * Removes booking from agency
 * @param booking bookings in list
 */
    public void removeBooking(BookableEntity booking) {
        bookings.remove(booking);
    }
}
