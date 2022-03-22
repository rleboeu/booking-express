/**
 * Class for Booking Agency, adding/removing from agency
 * @author Andrew Garcia
 */
package express; 
import java.util.*;

public class BookingAgency {
    String name;
    ArrayList<BookableEntity> bookings = new ArrayList<BookableEntity>();
    
/**
 * Contructor for booking Agency
 * @param name name of booking agency
 * @param bookings bookings in agency
 */
    public BookingAgency(String name, ArrayList<BookableEntity> bookings) {
        this.name = name;
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
    
    /**
     * Accessor for agency name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Mutator for agency name
     * @param name of agenc
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Accessor for agency's bookings
     * @return ArrayList<BookableEntity> bookings
     */
    public ArrayList<BookableEntity> getBookings() {
        return bookings;
    }

    /**
     * Mutator for bookings list
     * @param bookings new list
     */
    public void setBookings(ArrayList<BookableEntity> bookings) {
        this.bookings = bookings;
    }
}
