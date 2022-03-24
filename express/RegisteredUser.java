package express;

import java.util.ArrayList;
import java.util.UUID;


/**
 * is a user whos information for booking a flight is saved into the system
 * @author Miller Banford
 * @version 1.0.0
 */
public class RegisteredUser extends User {

    private UUID id;
    private String firstName;
    private String lastName;
    private String age;
    private boolean allowedToBook;
    private ArrayList<Passport> passports;
    private int numFlightsCurrentYear;
    private ArrayList<BookableEntity> bookingHistory;
    
    /**
     * 
     * @param id
     * @param firstName
     * @param lastName
     * @param age
     * @param allowedToBook
     * @param passports
     * @param bookingHistory
     * @param location
     */
    public RegisteredUser(UUID id, String firstName, String lastName, String age, boolean allowedToBook,
            ArrayList<Passport> passports, ArrayList<BookableEntity> bookingHistory, String location) {
        super(location);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.allowedToBook = allowedToBook;
        this.passports = passports;
        this.bookingHistory = bookingHistory;
    }

    /**
     * Constructer
     * @param firstName String
     * @param lastName String
     * @param age int
     * @param location String
     */
    public RegisteredUser(String firstName, String lastName, String age, String location) {
        super(location);
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        passports = new ArrayList<Passport>();
    }

    /**
     * adds a booking to the bookingHistory Array List
     * @param booking String uuid of booking
     */
    public void addBooking(BookableEntity booking) {
        if (allowedToBook) {
            this.bookingHistory.add(booking);
        }
    }

    /**
     * removes a booking to the bookingHistory Array List
     * @param booking String uuid of booking to be removed
     */
    public void removeBooking(BookableEntity booking) {
        bookingHistory.remove(booking);
    }

    /**
     * adds a passport to the passports Array List
     * @param passport String uuid of passport to be added
     */
    public void addPassport(Passport passport) {
        passports.add(passport);
    }

    /**
     * removes a passport to the passports Array List
     * @param passport String uuid of passport to be removed
     */
    public void removePassport(Passport passport) {
        passports.remove(passport);
    }
    
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + ", Age: " + this.age;
    }

    /**
     * Gets the booking history
     * @return ArrayList<BookableEntity>
     */
    public ArrayList<BookableEntity> getBookingHistory() {
        return bookingHistory;
    }

    /**
     * gets the UUID of the user
     * @return UUID
     */
    public UUID getUUID() {
        return id;
    }

}
