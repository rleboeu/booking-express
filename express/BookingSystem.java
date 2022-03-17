/**
 * Class for bookingSystem adding, removing, etc
 * @author Andrew Garcia
 */
package express;
import java.util.*;

public class BookingSystem {
    private ArrayList<BookableEntity> availableBookings = new ArrayList<BookableEntity>();
    private ArrayList<BookingAgency> bookingAgencies = new ArrayList<BookingAgency>();
    private FlightFilter flightFilter;

    public BookingSystem(){
        ArrayList<BookableEntity> availableBookings;
        ArrayList<BookingAgency> bookingAgencies;
        FlightFilter flightFilter;
    }
    public BookingSystem(ArrayList<BookableEntity> availableBookings) {
        
        this.availableBookings = availableBookings;
    }
    public void addBooking(BookableEntity booking) {
        availableBookings.add(booking);
    }
    public void removeBooking(BookableEntity booking) {
        availableBookings.remove(booking);
    }
    public void reserveBooking(RegisteredUser user, BookableEntity entity) {
        
    }
    public void cancelBooking(RegisteredUser user, BookableEntity entity) {

    }
}