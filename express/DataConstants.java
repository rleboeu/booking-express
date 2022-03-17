package express;

/**
 * Data constants for DataHandler
 */
public abstract class DataConstants {
    
    // Constants common to more than one JSON file
    public static final String ID = "id";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    
    // Constants for passports.json
    public static final String PASSPORT_DATE_OF_BIRTH = "dateOfBirth";
    public static final String PASSPORT_NATIONALITY = "nationality";
    public static final String PASSPORT_PLACE_OF_BIRTH = "placeOfBirth";
    public static final String PASSPORT_SEX = "sex";
    public static final String PASSPORT_DATE_ISSUED = "dateIssued";
    public static final String PASSPORT_DATE_EXIPIRATION = "dateExpiration";
    public static final String PASSPORT_DESTINATION_HISTORY = "destinationHistory";

    // Constants for users.json
    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";
    public static final String USER_AGE = "age";
    public static final String USER_ALLOWED_TO_BOOK = "allowedToBook";
    public static final String USER_BOOKING_HISTORY = "bookingHistory";
    public static final String USER_PASSPORTS = "passports";


}
