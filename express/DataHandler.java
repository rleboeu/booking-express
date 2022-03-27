package express;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
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
    
    private static JSONParser parser = new JSONParser();
    
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
        ArrayList<BookableEntity> lstEntities = new ArrayList<BookableEntity>();

        JSONArray flights = DataHandler.createJsonArray(DataConstants.FILEPATH_FLIGHTS);
        JSONArray cars = DataHandler.createJsonArray(DataConstants.FILEPATH_CARS);
        JSONArray hotels = DataHandler.createJsonArray(DataConstants.FILEPATH_HOTELS);

        // add flights
        for (Object obj : flights) {
            lstEntities.add(DataHandler.parseFlight((JSONObject) obj));
        }
        
        // add rental cars
        for (Object obj : cars) {
            lstEntities.add(DataHandler.parseCar((JSONObject) obj));
        }

        // add hotel rooms
        for (Object obj : hotels) {
            lstEntities.add(DataHandler.parseHotelRoom((JSONObject) obj));
        }

        return lstEntities;
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

        JSONArray jsonUsers = DataHandler.createJsonArray(DataConstants.FILEPATH_USERS);
        JSONObject jsonUser = null;
        String jsonUsername = null;
        String jsonPassword = null;

        // for each user in users.json
        boolean userApproved = false;
        for (Object jsonObj : jsonUsers) {
            jsonUser = (JSONObject) jsonObj;

            jsonUsername = (String) jsonUser.get(DataConstants.USER_USERNAME);
            jsonPassword = (String) jsonUser.get(DataConstants.USER_PASSWORD);

            if (jsonUsername.equals(username) && jsonPassword.equals(password)) {
                userApproved = true;
                break;  // user found
            }
        }
        
        if (userApproved) {
            user = DataHandler.parseUser(jsonUser);
        }

        return user;
    }

    /**
     * Returns a list of all BookingAgencies in the database
     * @return ArrayList<BookingAgency> list of agencies
     */
    public static ArrayList<BookingAgency> loadAgencies() {
        ArrayList<BookingAgency> agencies = new ArrayList<BookingAgency>();

        JSONArray jsonAgencies = DataHandler.createJsonArray(DataConstants.FILEPATH_AGENCIES);
        JSONObject jsonAgency;

        // for each agency in the json file
        for (Object jsonObj : jsonAgencies) {
            jsonAgency = (JSONObject) jsonObj;
            agencies.add(DataHandler.parseAgency(jsonAgency));
        }

        return agencies;
    }

    /**
     * Returns all entities in file
     * @param filepath of file
     * @return JSONArray
     */
    private static JSONArray createJsonArray(String filepath) {
        JSONArray array = null;
        try {
            array = (JSONArray) DataHandler.parser.parse(new FileReader(filepath));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return array;
    }

    /**
     * Parses a JSONObject into a Flight
     * @param jsonFlight JSONObject
     * @return Flight
     */
    private static Flight parseFlight(JSONObject jsonFlight) {
        String jsonUUID = (String) jsonFlight.get(DataConstants.ID);
        String jsonName = (String) jsonFlight.get(DataConstants.NAME);
        boolean jsonAvailable = (Boolean) jsonFlight.get(DataConstants.AVAILABLE);
        String jsonDepTime = (String) jsonFlight.get(DataConstants.FLIGHT_DEPARTURE_TIME);
        String jsonArrTime = (String) jsonFlight.get(DataConstants.FLIGHT_ARRIVAL_TIME);
        Airport jsonArrivalAir = Airport.valueOf((String) jsonFlight.get(DataConstants.FLIGHT_ARRIVAL_AIR));
        Airport jsonDepartAir = Airport.valueOf((String) jsonFlight.get(DataConstants.FLIGHT_DEPARTURE_AIR));
        double jsonPrice = Double.parseDouble((String) jsonFlight.get(DataConstants.FLIGHT_PRICE));
        JSONArray jsonSeatMap = (JSONArray) jsonFlight.get(DataConstants.FLIGHT_SEAT_MAP);
        JSONArray jsonReviews = (JSONArray) jsonFlight.get(DataConstants.FLIGHT_REVIEWS);

        // convert seatMap to boolean[][]
        boolean[][] seatMap = null;
        JSONArray row;
        int rowIndex = 0;
        for (Object obj : jsonSeatMap) {    // for each row of the JSONArray
            row = (JSONArray) obj;
            if (rowIndex == 0) {
                seatMap = new boolean[jsonSeatMap.size()][row.size()];
            }

            // for each column in row
            for (int columnIndex = 0; columnIndex < row.size(); ++columnIndex) {
                seatMap[rowIndex][columnIndex] = (Boolean)row.get(columnIndex);
            }

            rowIndex++;
        }

        // add reviews to arraylist
        ArrayList<Review> reviews = new ArrayList<Review>();
        JSONObject jsonReview;
        for (Object obj : jsonReviews) {
            jsonReview = (JSONObject) obj;
            reviews.add(DataHandler.parseReview(jsonReview));
        }

        // create the flight from the loaded data
        return new Flight(UUID.fromString(jsonUUID), jsonName, jsonPrice, jsonAvailable, jsonDepTime, jsonArrTime, jsonDepartAir, jsonArrivalAir, seatMap, reviews);
    }

    /**
     * Parses a JSONObject into a Review
     * @param jsonReview JSONObject
     * @return Review
     */
    private static Review parseReview(JSONObject jsonReview) {
        double rating = Double.parseDouble((String) jsonReview.get(DataConstants.REVIEW_RATING));
        String name = (String) jsonReview.get(DataConstants.REVIEW_NAME);
        String comments = (String) jsonReview.get(DataConstants.REVIEW_COMMENTS);

        return new Review(name, rating, comments);
    }

    /**
     * Parses a JSONObject into a BookingAgency
     * @param jsonAgency JSONObject
     * @return BookingAgency
     */
    private static BookingAgency parseAgency(JSONObject jsonAgency) {
        String agencyName = (String)jsonAgency.get(DataConstants.AGENCY_NAME);
        JSONArray jsonBookings = (JSONArray)jsonAgency.get(DataConstants.AGENCY_BOOKINGS);
        ArrayList<String> lstBookings = new ArrayList<String>();

        for (Object obj : jsonBookings) {
            lstBookings.add((String) obj);
        }

        return new BookingAgency(agencyName, lstBookings);
    }

    /**
     * Parses a JSONObject into a RegisteredUser
     * @param jsonUser JSONObject
     * @return RegisteredUser
     */
    private static RegisteredUser parseUser(JSONObject jsonUser) {
        UUID loadId = UUID.fromString( (String) jsonUser.get(DataConstants.ID) );
        String loadFirstName = (String) jsonUser.get(DataConstants.FIRST_NAME);
        String loadLastName = (String) jsonUser.get(DataConstants.LAST_NAME);
        String location = (String) jsonUser.get(DataConstants.USER_LOCATION);
        int loadAge = (Integer) jsonUser.get(DataConstants.USER_AGE);
        boolean loadAllowed = (Boolean) jsonUser.get(DataConstants.USER_ALLOWED_TO_BOOK);
        
        JSONArray jsonHistory = (JSONArray) jsonUser.get(DataConstants.USER_BOOKING_HISTORY);
        JSONArray jsonPassports = (JSONArray) jsonUser.get(DataConstants.USER_PASSPORTS);

        ArrayList<Passport> passports = new ArrayList<Passport>();
        ArrayList<BookableEntity> bookingHistory = new ArrayList<BookableEntity>();

        // load all passports
        JSONObject jsonObj;
        for (Object obj : jsonPassports) {
            jsonObj = (JSONObject) obj;
            passports.add(DataHandler.parsePassport(jsonObj));
        }

        // booking history
        UUID tempId;
        BookableEntity tempEntity;
        for (Object obj : jsonHistory) {
            tempId = UUID.fromString((String) obj);
            jsonObj = DataHandler.findEntity(tempId, DataConstants.FILEPATH_FLIGHTS);
            tempEntity = DataHandler.parseFlight(jsonObj);
            bookingHistory.add(tempEntity);
        }

        // TODO

        return new RegisteredUser(loadId, loadFirstName, loadLastName, loadAge, loadAllowed, passports, bookingHistory, location);
    }

    /**
     * Parses a JSONObject into a Passport
     * @param jsonPassport JSONObject
     * @return Passport
     */
    private static Passport parsePassport(JSONObject jsonPassport) {
        UUID id = UUID.fromString((String) jsonPassport.get(DataConstants.ID));
        String firstName = (String) jsonPassport.get(DataConstants.FIRST_NAME);
        String lastName = (String) jsonPassport.get(DataConstants.LAST_NAME);
        String dateOfBirth = (String) jsonPassport.get(DataConstants.PASSPORT_DATE_OF_BIRTH);
        String nationality = (String) jsonPassport.get(DataConstants.PASSPORT_NATIONALITY);
        String placeOfBirth = (String) jsonPassport.get(DataConstants.PASSPORT_PLACE_OF_BIRTH);
        String sex = (String) jsonPassport.get(DataConstants.PASSPORT_SEX);
        String dateIssued = (String) jsonPassport.get(DataConstants.PASSPORT_DATE_ISSUED);
        String dateExpiration = (String) jsonPassport.get(DataConstants.PASSPORT_DATE_EXIPIRATION);
        JSONArray jsonDestHist = (JSONArray) jsonPassport.get(DataConstants.PASSPORT_DESTINATION_HISTORY);
        ArrayList<String> destinationHistory = new ArrayList<String>();

        for (Object obj : jsonDestHist) {
            destinationHistory.add(String.valueOf((String) obj));
        }

        return new Passport(id, firstName, lastName, dateOfBirth, nationality, placeOfBirth, sex, dateIssued, dateExpiration, destinationHistory);
    }

    /**
     * Parses a JSONObject into a RentalCar
     * @param jsonCar JSONObject
     * @return RentalCar
     */
    private static RentalCar parseCar(JSONObject jsonCar) {
        UUID id = UUID.fromString( (String) jsonCar.get(DataConstants.ID));
        String name = (String) jsonCar.get(DataConstants.CAR_NAME);
        double price = (Double) jsonCar.get(DataConstants.CAR_PRICE);
        boolean available = (Boolean) jsonCar.get(DataConstants.AVAILABLE);
        CarStyle style = CarStyle.valueOf((String) jsonCar.get(DataConstants.CAR_STYLE));
        ArrayList<CarFeature> features = new ArrayList<CarFeature>();
        JSONArray jsonFeatures = (JSONArray) jsonCar.get(DataConstants.CAR_FEATURES);

        // Convert strings in features to CarFeature enum
        for (Object obj : jsonFeatures) {
            features.add(CarFeature.valueOf((String) obj));
        }

        LocalDate startDay = LocalDate.parse((String) jsonCar.get(CAR_START_DAY));
        LocalDate endDay = LocalDate.parse((String) jsonCar.get(CAR_END_DAY));
        int numSeats = (Integer) jsonCar.get(CAR_NUM_SEATS);
        JSONArray jsonReviews = (JSONArray) jsonCar.get(CAR_REVIEWS);
        ArrayList<Review> reviews = new ArrayList<Review>();

        for (Object obj : jsonReviews) {
            reviews.add(DataHandler.parseReview((JSONObject) obj));
        }

        return new RentalCar(id, name, price, available, style, features, startDay, endDay, numSeats, reviews);
    }

    /**
     * Parses a JSONObject into a HotelRoom
     * @param jsonHotel JSONObject
     * @return HotelRoom
     */
    private static HotelRoom parseHotelRoom(JSONObject jsonHotel) {
        UUID id = UUID.fromString( (String) jsonHotel.get(DataConstants.ID));
        String name = (String) jsonHotel.get(DataConstants.NAME);
        double price = Double.parseDouble((String) jsonHotel.get(DataConstants.CAR_PRICE));
        boolean available = (Boolean) jsonHotel.get(AVAILABLE);
        String availabilityStart = (String) jsonHotel.get(HOTEL_AVAIL_START);
        String availabilityEnd = (String) jsonHotel.get(HOTEL_AVAIL_END);
        LocalDate availStart = LocalDate.parse(availabilityStart);
        LocalDate availEnd = LocalDate.parse(availabilityEnd);
        int numBeds = Integer.parseInt((String) jsonHotel.get(HOTEL_NUM_BEDS));
        Airport nearAirportCode = Airport.valueOf((String) jsonHotel.get(HOTEL_NEAR_AIRPORT));
        ArrayList<Review> reviews = new ArrayList<Review>();
        JSONArray jsonReviews = (JSONArray) jsonHotel.get(HOTEL_REVIEWS);

        for (Object obj : jsonReviews) {
            reviews.add(DataHandler.parseReview((JSONObject) obj));
        }

        return new HotelRoom(id, name, price, available, numBeds, nearAirportCode, availStart, availEnd, reviews);
    }

    /**
     * Finds and returns an entity as JSONObject with matching UUID and entity type
     * @param id of object
     * @param filepath path to file
     * @return JSONObject
     */
    private static JSONObject findEntity(UUID id, String filepath) {
        JSONObject jsonTemp = null;
        JSONArray entitiesInFile;
        String jsonUUID = null;

        try {
            entitiesInFile = (JSONArray) (DataHandler.parser.parse(new FileReader(filepath)));

            for (Object obj : entitiesInFile) {
                jsonTemp = (JSONObject) obj;
                jsonUUID = (String) jsonTemp.get(DataConstants.ID);
    
                // if match, jsonTemp is the correct entity
                if (jsonUUID.equals(id.toString())) {
                    break;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return jsonTemp;
    }

    

}
