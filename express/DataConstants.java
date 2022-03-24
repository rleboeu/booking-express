package express;

/**
 * Data constants for DataHandler
 * @author rleboeu
 * @version 1.0.0
 */
public abstract class DataConstants {
    
    // Constants for filepaths
    protected static final String FILEPATH_FLIGHTS = "json/flights.json";
    protected static final String FILEPATH_CARS = "json/cars.json";
    protected static final String FILEPATH_HOTELS = "json/hotelrooms.json";
    protected static final String FILEPATH_AGENCIES = "json/agencies.json";
    protected static final String FILEPATH_USERS = "json/users.json";
    protected static final String FILEPATH_PASSPORTS = "json/passports.json";

    // Constants common to more than one JSON file
    protected static final String ID = "id";
    protected static final String FIRST_NAME = "firstName";
    protected static final String LAST_NAME = "lastName";
    protected static final String NAME = "name";
    protected static final String AVAILABLE = "available";

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

    // Constants for flights.json
    protected static final String FLIGHT_DEPARTURE_TIME = "departureTime";
    protected static final String FLIGHT_ARRIVAL_TIME = "arrivalTime";
    protected static final String FLIGHT_DEPARTURE_CODE = "departureCode";
    protected static final String FLIGHT_ARRIVAL_CODE = "arrivalCode";
    protected static final String FLIGHT_PRICE = "price";
    protected static final String FLIGHT_SEAT_MAP = "seatMap";
    protected static final String FLIGHT_REVIEWS = "reviews";

    // Constants for hotelrooms.json
    protected static final String HOTEL_ROOM_NUMBER = "roomNumber";
    protected static final String HOTEL_PRICE = "pricePerNight";
    protected static final String HOTEL_AVAIL_START = "availabilityStart";
    protected static final String HOTEL_AVAIL_END = "availabilityEnd";
    protected static final String HOTEL_NUM_BEDS = "numBeds";
    protected static final String HOTEL_NEAR_AIRPORT_CODE = "nearAirportCode";
    protected static final String HOTEL_REVIEWS = "reviews";

    // Constants for cars.json
    protected static final String CAR_NAME = "name";
    protected static final String CAR_PRICE = "price";
    protected static final String CAR_STYLE = "style";
    protected static final String CAR_FEATURES = "features";
    protected static final String CAR_START_DAY = "startDay";
    protected static final String CAR_END_DAY = "endDay";
    protected static final String CAR_NUM_SEATS = "numSeats";
    protected static final String CAR_REVIEWS = "reviews";

    // Constants for agencies.json
    protected static final String AGENCY_NAME = "name";
    protected static final String AGENCY_BOOKINGS = "bookings";

    // Constants for reviews
    protected static final String REVIEW_RATING = "rating";
    protected static final String REVIEW_NAME = "firstName";
    protected static final String REVIEW_COMMENTS = "comments";

}
