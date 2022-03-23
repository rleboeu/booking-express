package express;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Class to handle connections between the database and the program
 * @author rleboeu
 * @version 1.0.0
 */
public final class DataHandler extends DataConstants {
    
    private static JSONParser parser;

    /**
     * Replaces the corresponding data in the JSON file with the parameter's data. 
     * If no JSON object exists with entity's UUID, a new JSON object will be created and saved.
     * @param entity to save (or create) 
     */
    public static void saveEntity(BookableEntity entity) {
        // TODO
    }

    /**
     * Replaces the corresponding data in the JSON file with the parameter's data.
     * If no JSON object exists with user's UUID, a new JSON object will be created and saved.
     * @param user to save (or create)
     */
    public static void saveUser(RegisteredUser user) {
        // TODO
    }

    /**
     * Returns all BookableEntity object present in the JSON files cars.json, flights.json, and hotelrooms.json.
     * @return ArrayList<BookableEntity> all 'bookings' present in the JSON files.
     */
    public static ArrayList<BookableEntity> loadEntities() {
        return null;    // TODO
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
        DataHandler.parser = new JSONParser();

        try {
            JSONArray jsonUsers = (JSONArray) (DataHandler.parser.parse(new FileReader("json/users.json")));
            JSONObject jsonUser = null;
            String jsonUsername = null;
            String jsonPassword = null;

            // for each user in users.json
            for (Object jsonObj : jsonUsers) {
                jsonUser = (JSONObject) jsonObj;

                jsonUsername = (String) jsonUser.get(DataConstants.USER_USERNAME);
                jsonPassword = (String) jsonUser.get(DataConstants.USER_PASSWORD);

                if (jsonUsername.equals(username) && jsonPassword.equals(password)) {
                    break;  // user found
                }
            }

            // load the RegisteredUser
            UUID loadId = UUID.fromString( (String) jsonUser.get(DataConstants.ID) );
            String loadFirstName = (String) jsonUser.get(DataConstants.FIRST_NAME);
            String loadLastName = (String) jsonUser.get(DataConstants.LAST_NAME);
            int loadAge = (Integer) jsonUser.get(DataConstants.USER_AGE);
            boolean loadAllowed = (Boolean) jsonUser.get(DataConstants.USER_ALLOWED_TO_BOOK);
            
            JSONArray jsonHistory = (JSONArray) jsonUser.get(DataConstants.USER_BOOKING_HISTORY);
            JSONArray jsonPassports = (JSONArray) jsonUser.get(DataConstants.USER_PASSPORTS);

            ArrayList<String> loadBookingHistory = DataHandler.jsonArrayToList(jsonHistory);
            ArrayList<String> loadPassports = DataHandler.jsonArrayToList(jsonPassports);

            user = new RegisteredUser(loadId, loadFirstName, loadLastName, loadAge, loadAllowed, loadPassports, loadBookingHistory, "");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * Load a Flight from the database
     * @param uuid of Flight to load
     * @return Flight object
     */
    public static Flight loadFlight(UUID uuid) {
        Flight flight = null;

        try {
            JSONArray jsonAllFlights = (JSONArray) (DataHandler.parser.parse(new FileReader("json/flights.java")));

            // match the parameter uuid with the uuid in the json
            JSONObject jsonFlight = null;
            String jsonUUID = null;
            for (Object obj : jsonAllFlights) {
                jsonFlight = (JSONObject) obj;
                jsonUUID = (String) jsonFlight.get(DataConstants.ID);

                // if match
                if (jsonUUID.equals(uuid.toString())) {
                    break;
                }
            }

            // load data from the json into variables
            String jsonDepTime = (String) jsonFlight.get(DataConstants.FLIGHT_DEPARTURE_TIME);
            String jsonArrTime = (String) jsonFlight.get(DataConstants.FLIGHT_ARRIVAL_TIME);
            int jsonDepCode = Integer.parseInt((String) jsonFlight.get(DataConstants.FLIGHT_DEPARTURE_CODE));
            int jsonArrCode = Integer.parseInt((String) jsonFlight.get(DataConstants.FLIGHT_ARRIVAL_CODE));
            double jsonPrice = Double.parseDouble((String) jsonFlight.get(DataConstants.FLIGHT_PRICE));
            JSONArray jsonSeatMap = (JSONArray) jsonFlight.get(DataConstants.FLIGHT_SEAT_MAP);
            JSONArray jsonReviews = (JSONArray) jsonFlight.get(DataConstants.FLIGHT_REVIEWS);
            ArrayList<Review> reviews = DataHandler.reviewsFromJsonArray(jsonReviews);

            // convert seatMap to boolean[][]
            boolean[][] seatMap = null;
            JSONArray row;
            int count = 0;
            for (Object obj : jsonSeatMap) {
                row = (JSONArray) obj;
                if (count == 0) {
                    seatMap = new boolean[jsonSeatMap.size()][row.size()];
                }

                for (int i = 0; i < row.size(); ++i) {
                    seatMap[count][i] = (Boolean)row.get(i);
                }

                count++;
            }

            // create the flight from the loaded data
            flight = new Flight(UUID.fromString(jsonUUID), jsonPrice, jsonDepTime, jsonArrTime, jsonDepCode, jsonArrCode, seatMap, reviews);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return flight;
    }

    /**
     * Returns a list of all BookingAgencies in the database
     * @return ArrayList<BookingAgency> list of agencies
     */
    public static ArrayList<BookingAgency> loadAgencies() {
        ArrayList<BookingAgency> agencies = new ArrayList<BookingAgency>();
        DataHandler.parser = new JSONParser();

        try {
            JSONArray jsonAgencies = (JSONArray) (DataHandler.parser.parse(new FileReader("json/agencies.json")));
            JSONObject jsonObj;
            ArrayList<String> lstBookings = new ArrayList<String>();
            JSONArray jsonBookings;
            String agencyName;

            // for each agency in the json file
            for (Object jsonAgency : jsonAgencies) {
                jsonObj = (JSONObject) jsonAgency;
                agencyName = (String)jsonObj.get(DataConstants.AGENCY_NAME);
                jsonBookings = (JSONArray)jsonObj.get(DataConstants.AGENCY_BOOKINGS);

                lstBookings = DataHandler.jsonArrayToList(jsonBookings);

                agencies.add(new BookingAgency(agencyName, lstBookings));
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return agencies;
    }

    private static ArrayList<Review> reviewsFromJsonArray(JSONArray jsonReviews) {
        ArrayList<Review> reviews = new ArrayList<Review>();
    
        double rating;
        String name, comments;
        JSONObject jsonReview;
        for (Object obj : jsonReviews) {
            jsonReview = (JSONObject) obj;
            rating = Double.parseDouble((String) jsonReview.get(DataConstants.REVIEW_RATING));
            name = (String) jsonReview.get(DataConstants.REVIEW_NAME);
            comments = (String) jsonReview.get(DataConstants.REVIEW_COMMENTS);

            reviews.add(new Review(name, rating, comments));
        }
        
        return reviews;
    }

    /**
     * Converts a JSONArray to an ArrayList of generic type
     * @param <T> generic type
     * @param jsonArray JSONArray to convert
     * @return ArrayList<T> list
     */
    private static <T> ArrayList<T> jsonArrayToList(JSONArray jsonArray) {
        ArrayList<T> list = new ArrayList<T>();

        T jsonT;
        for (Object jsonObj : jsonArray) {
            jsonT = (T)jsonObj;
            list.add(jsonT);
        }

        return list;
    }

}
