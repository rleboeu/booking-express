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
    private int age;
    private boolean allowedToBook;
    private ArrayList<String> passports;
    private int numFlightsCurrentYear;
    private ArrayList<String> bookingHistory;
    
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
    public RegisteredUser(UUID id, String firstName, String lastName, int age, boolean allowedToBook,
            ArrayList<String> passports, ArrayList<String> bookingHistory, String location) {
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
    public RegisteredUser(String firstName, String lastName, int age, String location) {
        super(location);
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * adds a booking to the bookingHistory Array List
     * @param booking String uuid of booking
     */
    public void addBooking(String booking) {
        if (allowedToBook) {
            this.bookingHistory.add(booking);
        }
    }

    /**
     * removes a booking to the bookingHistory Array List
     * @param booking String uuid of booking to be removed
     */
    public void removeBooking(String booking) {
        bookingHistory.remove(booking);
    }

    /**
     * adds a passport to the passports Array List
     * @param passport String uuid of passport to be added
     */
    public void addPassport(String passport) {
        passports.add(passport);
    }

    /**
     * removes a passport to the passports Array List
     * @param passport String uuid of passport to be removed
     */
    public void removePassport(String passport) {
        passports.remove(passport);
    }
    
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + ", Age: " + this.age;
    }

}
