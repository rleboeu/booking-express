package express;

import java.util.ArrayList;


/**
 * is a user whos information for booking a flight is saved into the system
 * @author Miller Banford
 * @version 1.0.0
 */
public class RegisteredUser extends User {

    private String firstName;
    private String lastName;
    private String dob;
    private boolean allowedToBook;
    private ArrayList<Passport> passports;
    private int numFlightsCurrentYear;
    private ArrayList<BookableEntity> bookingHistory;
    
    /**
     * Constructer
     * @param firstName String
     * @param lastName String
     * @param age int
     * @param allowedToBook boolean
     * @param passports ArrayList<Passport>
     * @param numFlightsCurrentYear int
     * @param bookingHistory ArrayList<BookableEntity>
     * @param location String
     */
    public RegisteredUser(String firstName, String lastName, String dob, boolean allowedToBook,
            ArrayList<Passport> passports, int numFlightsCurrentYear, ArrayList<BookableEntity> bookingHistory, String location) {
        super(location);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.allowedToBook = allowedToBook;
        this.passports = passports;
        this.numFlightsCurrentYear = numFlightsCurrentYear;
        this.bookingHistory = bookingHistory;
    }

    /**
     * Constructer
     * @param firstName String
     * @param lastName String
     * @param age int
     * @param location String
     */
    public RegisteredUser(String firstName, String lastName, String dob, String location) {
        super(location);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        passports = new ArrayList<Passport>();
    }

    /**
     * adds a booking to the bookingHistory Array List
     * @param booking BookableEntity to be added
     */
    public void addBooking(BookableEntity booking) {
        bookingHistory.add(booking);

    }

    /**
     * removes a booking to the bookingHistory Array List
     * @param booking BookableEntity to be removed
     */
    public void removeBooking(BookableEntity booking) {
        bookingHistory.remove(booking);
    }

    /**
     * adds a passport to the passports Array List
     * @param passport Passport to be added
     */
    public void addPassport(Passport passport) {
        passports.add(passport);
    }

    /**
     * removes a passport to the passports Array List
     * @param passport Passport to be removed
     */
    public void removePassport(Passport passport) {
        passports.remove(passport);
    }

    /**
     * Gets the booking history of a registered user
     * @return ArrayList<BookableEntity>
     */
    public ArrayList<BookableEntity> getBookingHistory() {
        return bookingHistory;
    }

    
    
}
