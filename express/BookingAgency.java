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
    
    public BookingAgency(String name, String AirportCode, ArrayList<BookableEntity> bookings) {
        this.name = name;
        this.AirportCode = AirportCode;
        this.bookings = bookings;
    }
    public BookingAgency(String name) {
        this.name = name;
    }
    public void addBooking(BookableEntity booking) {
        bookings.add(booking);
    }
    public void removeBooking(BookableEntity booking) {
        bookings.remove(booking);
    }
}
