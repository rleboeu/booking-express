package express;
import java.util.*;

import javax.swing.text.html.parser.Entity;

/**
 * Class for bookingSystem adding, removing, etc
 * @author Andrew Garcia, Ryan LeBoeuf
 */
public class BookingSystem {
    private ArrayList<BookableEntity> availableBookings = new ArrayList<BookableEntity>();
    private ArrayList<BookingAgency> bookingAgencies = new ArrayList<BookingAgency>();

    /**
     * Constructor
     */
    public BookingSystem() {
        this.availableBookings = new ArrayList<BookableEntity>();
        this.bookingAgencies = new ArrayList<BookingAgency>();
    }

    /**
     * Constructor
     */
    public BookingSystem(ArrayList<BookableEntity> bookableEntities) {
        this.availableBookings = bookableEntities;
        this.bookingAgencies = new ArrayList<BookingAgency>();
    }

    /**
     * Add a booking to the system
     * @param entity to add
     */
    public void addBooking(BookableEntity entity) {
        availableBookings.add(entity);
    }

    /**
     * Remove a booking from the system
     * @param entity to remove
     */
    public void removeBooking(BookableEntity entity) {
        availableBookings.remove(entity);
    }

    /**
     * Add a BookingAgency to the system
     * @param agency to add
     */
    public void addAgency(BookingAgency agency) {
        this.bookingAgencies.add(agency);
    }

    /**
     * Remove a BookingAgency from the system
     * @param agency to remove
     */
    public void removeAgency(BookingAgency agency) {
        this.bookingAgencies.remove(agency);
    }

    /**
     * Attempts to reserve booking for the user 
     * @param user to reserve booking for
     * @param entity to reserve for the user
     * @return boolean is successfull in booking
     */
    public boolean reserveBooking(RegisteredUser user, BookableEntity entity) {
        if (entity.isAvailable()) {
            entity.reserve();   // modify the entity
            user.addBooking(entity);    // modifty the user
            
            DataHandler.saveEntity(entity); // update the database
            DataHandler.saveUser(user); // update the database

            return true;    // Booking was successful
        } else {
            return false;   // Booking was not successful
        }
    }
    
    /**
     * Cancels an existing reservation of the entity by the user
     * @param user that reserved the entity
     * @param entity that was reserved
     */
    public void cancelBooking(RegisteredUser user, BookableEntity entity) {
        if (!entity.isAvailable()) {
            entity.cancelReserve();
            user.removeBooking(entity);

            DataHandler.saveEntity(entity);
            DataHandler.saveUser(user);
        }
    }

    public ArrayList<Flight> getFlights() {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        for(BookableEntity entity: availableBookings) {
            if(entity.isAFlight) {
                flights.add((Flight)entity);
            }
        }
        return flights;
    }
}