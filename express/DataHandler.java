package express;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Class to handle connections between the database and the program
 * @author rleboeu
 * @version 1.0.0
 */
public final class DataHandler extends DataConstants {
    
    /**
     * Replaces the corresponding data in the JSON file with the parameter's data. 
     * If no JSON object exists with entity's UUID, a new JSON object will be created and saved.
     * @param entity to save (or create) 
     */
    public static void saveEntity(BookableEntity entity) {
        if (entity instanceof Flight) {
            // flights.json
        } else if (entity instanceof RentalCar) {
            // cars.json
        } else if (entity instanceof HotelRoom) {
            // hotelrooms.json
        } else {
            // something went wrong...
        }
    }

    /**
     * Replaces the corresponding data in the JSON file with the parameter's data.
     * If no JSON object exists with user's UUID, a new JSON object will be created and saved.
     * @param user to save (or create)
     */
    public static void saveUser(RegisteredUser user) {
        // stub
    }

    /**
     * Returns all BookableEntity object present in the JSON files cars.json, flights.json, and hotelrooms.json.
     * @return ArrayList<BookableEntity> all 'bookings' present in the JSON files.
     */
    public static ArrayList<BookableEntity> loadEntities() {
        return null;
    }

    /**
     * Returns the user data assuming that username and password are both valid.
     * Returns null if the username or password are incorrect.
     * @param username
     * @param password
     * @return RegisteredUser if 'login' is successful, null otherwise
     */
    public static RegisteredUser loadUser(String username, String password) {
        RegisteredUser user = null;

        return user;
    }

    /**
     * Returns the BookableEntity that matches the UUID given
     * @param uuid of the BookableEntity
     * @return BookableEntity 
     */
    public static BookableEntity loadEntity(UUID uuid) {
        BookableEntity entity = null;

        return entity;
    }

    /**
     * Returns a list of all BookingAgencies in the database
     * @return ArrayList<BookingAgency> list of agencies
     */
    public static ArrayList<BookingAgency> loadAgencies() {
        ArrayList<BookingAgency> agencies = new ArrayList<BookingAgency>();
        
        return agencies;
    }

}
