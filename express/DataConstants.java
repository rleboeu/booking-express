package express;

/**
 * Data constants for DataHandler
 * @author rleboeu
 * @version 1.0.0
 */
public abstract class DataConstants {
    
    // Constants common to more than one JSON file
    protected static final String ID = "id";
    protected static final String FIRST_NAME = "firstName";
    protected static final String LAST_NAME = "lastName";
    
    // Constants for passports.json
    protected static final String PASSPORT_DATE_OF_BIRTH = "dateOfBirth";
    protected static final String PASSPORT_NATIONALITY = "nationality";
    protected static final String PASSPORT_PLACE_OF_BIRTH = "placeOfBirth";
    protected static final String PASSPORT_SEX = "sex";
    protected static final String PASSPORT_DATE_ISSUED = "dateIssued";
    protected static final String PASSPORT_DATE_EXIPIRATION = "dateExpiration";
    protected static final String PASSPORT_DESTINATION_HISTORY = "destinationHistory";

    // Constants for users.json
    protected static final String USER_USERNAME = "username";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_AGE = "age";
    protected static final String USER_ALLOWED_TO_BOOK = "allowedToBook";
    protected static final String USER_BOOKING_HISTORY = "bookingHistory";
    protected static final String USER_PASSPORTS = "passports";

    // Constants for agencies.json
    protected static final String AGENCY_NAME = "name";
    protected static final String AGENCY_BOOKINGS = "bookings";

}
