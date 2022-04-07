/**
 * Class for Booking Agency, adding/removing from agency
 * @author Andrew Garcia
 */
// package express; 
import java.util.*;

public class BookingAgency {
    String name;
    ArrayList<String> bookingIds = new ArrayList<String>();
    
/**
 * Contructor for booking Agency
 * @param name name of booking agency
 * @param bookings bookings in agency
 */
    public BookingAgency(String name, ArrayList<String> bookings) {
        this.name = name;
        this.bookingIds = bookings;
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
 * @param bookingId booking in list
 */
    public void addBooking(String bookingId) {
        bookingIds.add(bookingId);
    }
/**
 * Removes booking from agency
 * @param bookingId booking in list
 */
    public void removeBooking(String bookingId) {
        bookingIds.remove(bookingId);
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
     * @return ArrayList<String> booking ids
     */
    public ArrayList<String> getBookings() {
        return bookingIds;
    }

}
