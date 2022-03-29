package express;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
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
        String filepath = "";
        if (entity instanceof Flight) {
            filepath = DataConstants.FILEPATH_FLIGHTS;
        } else if (entity instanceof RentalCar) {
            filepath = DataConstants.FILEPATH_CARS;
        } else if (entity instanceof HotelRoom) {
            filepath = DataConstants.FILEPATH_HOTELS;
        }


    }

    private static JSONObject convertToJSON(Flight flight) {
        HashMap<String, Object> jsonFlight = new HashMap<String, Object>();

        jsonFlight.put(DataConstants.ID, flight.getUUID().toString());
        jsonFlight.put(DataConstants.NAME, flight.getName());
        jsonFlight.put(DataConstants.FLIGHT_DEPARTURE_TIME, flight.getDepartureTime().toString());
        jsonFlight.put(DataConstants.FLIGHT_ARRIVAL_TIME, flight.getArrivalTime().toString());
        jsonFlight.put(DataConstants.FLIGHT_DEPARTURE_AIR, flight.getArrivalCode());
        jsonFlight.put(DataConstants.FLIGHT_ARRIVAL_AIR, flight.getArrivalCode());
        jsonFlight.put(DataConstants.FLIGHT_PRICE, flight.getPrice());
    
        boolean[][] seatMap = flight.getSeatMapRaw();
        JSONArray jsonSeatMap = new JSONArray();
        JSONArray jsonSeatRow;
        for (int row = 0; row < seatMap.length; ++row) {
            jsonSeatRow = new JSONArray();
            for (int col = 0; col < seatMap[row].length; ++col) {
                jsonSeatRow.set(col, seatMap[row][col]);
            }
            jsonSeatMap.add(jsonSeatRow);
        }

        jsonFlight.put(DataConstants.FLIGHT_SEAT_MAP, jsonSeatMap);

        ArrayList<Review> reviews = flight.getReviews();
        JSONArray jsonReviews = new JSONArray();
        for (Review review : reviews) {
            jsonReviews.add(DataHandler.convertToJSON(review));
        }
        jsonFlight.put(DataConstants.FLIGHT_REVIEWS, jsonReviews);

        return new JSONObject(jsonFlight);
    }

    private static JSONObject convertToJSON(Review review) {
        HashMap<String, Object> jsonReview = new HashMap<String, Object>();

        jsonReview.put(DataConstants.REVIEW_NAME, review.getFirstName());
        jsonReview.put(DataConstants.REVIEW_RATING, review.getRating());
        jsonReview.put(DataConstants.REVIEW_COMMENTS, review.getComments());

        return new JSONObject(jsonReview);
    }

    private static JSONObject convertToJSON(RentalCar car) {
        HashMap<String, Object> jsonCar = new HashMap<String, Object>();

        jsonCar.put(DataConstants.ID, car.getUUID().toString());
        jsonCar.put(DataConstants.CAR_NAME, car.getName());
        jsonCar.put(DataConstants.CAR_PRICE, car.getPrice());
        jsonCar.put(DataConstants.CAR_STYLE, car.getStyle().toString());
        
        ArrayList<String> jsonFeatures = new ArrayList<String>();
        for (CarFeature feature : car.getFeatures()) {
            jsonFeatures.add(feature.toString());
        }
        jsonCar.put(DataConstants.CAR_FEATURES, jsonFeatures);
        jsonCar.put(DataConstants.CAR_START_DAY, car.getStartDay().toString());
        jsonCar.put(DataConstants.CAR_END_DAY, car.getEndDay().toString());
        jsonCar.put(DataConstants.CAR_NUM_SEATS, car.getNumSeats());
        jsonCar.put(DataConstants.AVAILABLE, car.isAvailable());
;
        JSONArray jsonReviews = new JSONArray();
        for (Review review : car.getReviews()) {
            jsonReviews.add(DataHandler.convertToJSON(review));
        }
        jsonCar.put(DataConstants.CAR_REVIEWS, jsonReviews);

        return new JSONObject(jsonCar);
    }

    private static JSONObject convertToJSON(HotelRoom room) {
        HashMap<String, Object> jsonHotel = new HashMap<String, Object>();



        return new JSONObject(jsonHotel);
    }

    /**
     * Replaces the corresponding data in the JSON file with the parameter's data.
     * If no JSON object exists with user's UUID, a new JSON object will be created and saved.
     * @param user to save (or create)
     */
    public static void saveUser(RegisteredUser user) {
        try {
            JSONArray allUsers = DataHandler.createJsonArray(DataConstants.FILEPATH_USERS);
            FileWriter file = new FileWriter(DataConstants.FILEPATH_USERS);
            
            JSONObject givenUser = DataHandler.userToJSON(user);

            // Attempt to find the user in the file
            JSONObject potentialUser;
            boolean userExists = false;
            int index;
            String potentialUUID;
            for (index = 0; index < allUsers.size(); ++index) {
                potentialUser = (JSONObject) allUsers.get(index);
                potentialUUID = (String) potentialUser.get(DataConstants.ID);
                if (potentialUUID.equals(user.getUUID().toString())) {
                    // The user exists, therefore modify the potential user
                    userExists = true;
                    break;
                }
            }
            
            // If the user does not already exist in the file, givenUser will 
            // be added to the file instead of updating the potentialUser
            if (userExists) {
                allUsers.set(index, givenUser);
            } else {
                allUsers.add(givenUser);
            }

            // Save changes by writing to the file
            file.write(allUsers.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Convert a RegisteredUser object to a JSONObject
     * @param user RegisteredUser
     * @return JSONObject
     */
    private static JSONObject userToJSON(RegisteredUser user) {
        HashMap<String, Object> jsonUser = new HashMap<String, Object>();

        jsonUser.put(DataConstants.FIRST_NAME, user.getFirstName());
        jsonUser.put(DataConstants.LAST_NAME, user.getLastName());
        jsonUser.put(DataConstants.USER_PASSWORD, user.getPassword());
        jsonUser.put(DataConstants.USER_BOOKING_HISTORY, user.getBookingHistoryIDs());
        jsonUser.put(DataConstants.USER_LOCATION, user.getLocation());
        jsonUser.put(DataConstants.ID, user.getUUID().toString());
        jsonUser.put(DataConstants.USER_PASSPORTS, user.getPassportIDs());
        jsonUser.put(DataConstants.USER_AGE, user.getAge());
        jsonUser.put(DataConstants.USER_USERNAME, user.getUsername());
        jsonUser.put(DataConstants.USER_ALLOWED_TO_BOOK, user.getAllowedToBook());

        return new JSONObject(jsonUser);
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
        double jsonPrice = (Double) jsonFlight.get(DataConstants.FLIGHT_PRICE);
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
        double rating = (Double) jsonReview.get(DataConstants.REVIEW_RATING);
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
        String username = (String) jsonUser.get(DataConstants.USER_USERNAME);
        String password = (String) jsonUser.get(DataConstants.USER_PASSWORD);
        int loadAge = ((Long) jsonUser.get(DataConstants.USER_AGE)).intValue();
        boolean loadAllowed = (Boolean) jsonUser.get(DataConstants.USER_ALLOWED_TO_BOOK);
        
        JSONArray jsonHistory = (JSONArray) jsonUser.get(DataConstants.USER_BOOKING_HISTORY);
        JSONArray jsonPassports = (JSONArray) jsonUser.get(DataConstants.USER_PASSPORTS);

        ArrayList<Passport> passports = new ArrayList<Passport>();
        ArrayList<BookableEntity> bookingHistory = new ArrayList<BookableEntity>();

        // load all passports
        UUID jsonUUID;
        JSONObject jsonObj;
        for (Object obj : jsonPassports) {
            jsonUUID = UUID.fromString((String) obj);
            jsonObj = DataHandler.findEntity(jsonUUID, DataConstants.FILEPATH_PASSPORTS);
            passports.add( DataHandler.parsePassport(jsonObj) );
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

        return new RegisteredUser(loadId, loadFirstName, loadLastName, username, password, loadAge, loadAllowed, passports, bookingHistory, location);
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
        ArrayList<Airport> destinationHistory = new ArrayList<Airport>();

        for (Object obj : jsonDestHist) {
            destinationHistory.add(Airport.valueOf((String) obj));
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
        int numSeats = ((Long) jsonCar.get(CAR_NUM_SEATS)).intValue();
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
        double price = (Double) jsonHotel.get(DataConstants.HOTEL_PRICE);
        boolean available = (Boolean) jsonHotel.get(AVAILABLE);
        String availabilityStart = (String) jsonHotel.get(HOTEL_AVAIL_START);
        String availabilityEnd = (String) jsonHotel.get(HOTEL_AVAIL_END);
        LocalDate availStart = LocalDate.parse(availabilityStart);
        LocalDate availEnd = LocalDate.parse(availabilityEnd);
        int numBeds = ((Long) jsonHotel.get(HOTEL_NUM_BEDS)).intValue();
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
