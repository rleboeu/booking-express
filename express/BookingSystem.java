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
    /**
     * Attempts to reserve booking for the user 
     * @param user to reserve booking for
     * @param entity to reserve for the user
     * @return boolean is successfull in booking
     */
    public boolean reserveBooking(RegisteredUser user, BookableEntity entity) {
        if (entity.isAvailable()) {
            entity.reserve(user);
            // JSON stuff
            return true;
        } else {
            return false;
        }
    }
    
    public void cancelBooking(RegisteredUser user, BookableEntity entity) {

    }
}