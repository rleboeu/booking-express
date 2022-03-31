package express;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The connsole interface with the user
 * @author Miller Banford
 * @version 1.0.0
 */
public class ConsoleBookingExpress {

    private static ConsoleBookingExpress consoleBookingExpress;
    private ArrayList<String> options;
    private User user;
    private RegisteredUser registeredUser;
    private Scanner reader;
    private HashMap<String, String> inputs;
    private ArrayList<BookableEntity> bookableEntities;
    private HotelFilter hotelFilter;
    private ArrayList<String> hotels;
    private FlightFilter flightFilter;
    private ArrayList<String> airlines;

    /**
     * Constructer
     */
    private ConsoleBookingExpress() {
        System.out.println("Welcome to Booking Express!\n");
        user = new User("");
        registeredUser = null;
        inputs = new HashMap<String, String>();
        options = new ArrayList<String>(); 
        reader = new Scanner(System.in);
        flightFilter = new FlightFilter();
        //bookableEntities = DataHandler.loadEntities();
    }

    /**
     * gets the current instance for the console or makes a new one
     * @return ConsoleBookingExpress
     */
    public static ConsoleBookingExpress getInstantsConsoleBookingExpress() {
        if (consoleBookingExpress == null) {
            consoleBookingExpress = new ConsoleBookingExpress();
        }
        return consoleBookingExpress;
    }

    /**
     * Prints out the main menu and waits for the user input to go to the next screen
     */
    public void mainMenu() {
        System.out.println("******* Main Menu ********\n");
        addMainMenuOptions();
        printOptions();
        System.out.println("What would you like to do?\n");
        readMainMenuInput();
    }

    /**
     * adds the options for the main menu
     */
    private void addMainMenuOptions() {
        options.clear();
        options.add("1. Search Flights");
        options.add("2. Search Hotels");
        options.add("3. Search Rental Car");
        if(registeredUser == null) {
            options.add("4. Login");
            options.add("5. Create Account");
        }
        else {
            options.add("4. Logout");
            options.add("5. My Bookings");
        }
        options.add("6. Quit");
    }

    /**
     * prints the options array list
     */
    private void printOptions() {
        for(String option: options) {
            System.out.println(option +"\n");
        }
    }

    /**
     * Reads the input from the user on the main menu and takes them to the next selected screen
     */
    private void readMainMenuInput() {
        boolean validInput = false;
        while(!validInput){
            String input = reader.nextLine();
            switch(input) {
                case "1": validInput = true;
                    searchFlightScreen();
                    break;
                case "2": validInput = true;
                    break;
                case "3": validInput = true;
                    break;
                case "4": validInput = true;
                    if(options.get(3) == "4. Logout") {
                        registeredUser = null;
                        clear();
                        mainMenu();
                    }
                    else {
                        loginScreen();
                    }
                    break;
                case "5": validInput = true;
                    if(registeredUser == null) { createAccoutnScreen(false);}
                    else { bookingHistoryScreen(); }
                    break;
                case "6": validInput = true;
                    System.exit(0);
                    break;
                default: System.out.println("Invalid input");
                    break;
            }
        }
    }

    /**
     * prints the Account Creation screen and waits for user input
     */
    private void createAccoutnScreen(boolean hasHashMap) {
        clear();
        System.out.println("***** Create Account *****\n");
        addCreateAccountOptions();
        if(!hasHashMap){
            inputs.clear();
            inputs = fillHashmap();
        }
        printOptionsWithHashMap(inputs);
        System.out.println("What would you like to do?\n");
        readCreateAccountInput(inputs);
    }

    /**
     * adds the options to be printed for the create account screen
     */
    private void addCreateAccountOptions() {
        options.clear();
        options.add("1. First Name");
        options.add("2. Last Name");
        options.add("3. Date of Birth");
        options.add("4. Nationality");
        options.add("5. Sex");
        options.add("6. Issue Date");
        options.add("7. Expiration Date");
        options.add("8. Passport Number");
        options.add("9. Age");
        options.add("10. Done");
        options.add("11. Exit");
    }

    /**
     * fills a hasmap with the options strings as the keys and an empty string as the value, 
     * exept the last value which has done as its value
     * @return HashMap<String, String>
     */
    private HashMap<String, String> fillHashmap() {
        HashMap<String,String> input = new HashMap<String, String>();
        for(String option: options) {
            input.put(option, "");
        }
        input.put(options.get(9), "Done");
        input.put(options.get(10), "Exit");
        return input;
    }

    /**
     * Prints out options followed by an associated value on a hash map
     * @param input HashMap<String, String> values are the users inputs
     */
    private void printOptionsWithHashMap(HashMap<String, String> input) {
        for(int i = 0; i < options.size() - 2; i++) {
            System.out.println(options.get(i) + ": " + input.get(options.get(i)));
        }
        System.out.println(options.get(8));
        System.out.println(options.get(9));
        System.out.println("\n");
    }

    /**
     * Reads the input from the user on the create account and takes them to the next selected screen
     */
    private void readCreateAccountInput(HashMap<String, String> inputs) {
        boolean validInput = false;
        int ageInYears = 0;
        while(!validInput){
            String input = reader.nextLine();
            switch(input) {
                case "1": validInput = true;
                    inputValueScreen("1. First Name", inputs);
                    break;
                case "2": validInput = true;
                    inputValueScreen("2. Last Name", inputs);
                    break;
                case "3": validInput = true;
                    inputValueScreen("3. Date of Birth", inputs);
                    break;
                case "4": validInput = true;
                    inputValueScreen("4. Nationality", inputs);
                    break;
                case "5": validInput = true;
                    inputValueScreen("5. Sex", inputs);
                    break;
                case "6": validInput = true;
                    inputValueScreen("6. Issue Date", inputs);
                    break;
                case "7": validInput = true;
                    inputValueScreen("7. Expiration Date", inputs);
                    break;
                case "8": validInput = true;
                    inputValueScreen("8. Passport Number", inputs);
                    break;
                case "9": validInput = true;
                    inputValueScreen("9. Age", inputs);
                    break;
                case "10": validInput = true;
                    if(checkIfDone(inputs)) {
                        try {
                            ageInYears = Integer.parseInt(inputs.get("9. Age"));
                        }
                        catch (NumberFormatException e) {
                            ageInYears = 0;
                        }
                        registeredUser = user.createAccoutn(inputs.get("1. First Name"), inputs.get("2. Last Name"), 
                            ageInYears);
                        fillOutPassport(inputs);
                        clear();
                        mainMenu();
                    }
                    else {
                        createAccoutnScreen(true);
                    }
                    break;
                case "11": validInput = true;
                    clear();
                    mainMenu();
                    break;
                default: System.out.println("Invalid input");
                    break;
            }
            
        }
    }

    /**
     * Screen where the user iputs a value for a given hash table
     * @param value String the key for the hash table
     * @param inputs HashTable<String, String>
     */
    private void inputValueScreen(String value, HashMap<String, String> inputs) {
        clear();
        System.out.println("***** Create Account *****\n");
        System.out.println("Enter " + value + ":");
        String input = reader.nextLine();
        inputs.put(value, input);
        createAccoutnScreen(true);
        
    }

    /**
     * Checks if the user has inputted all values on the create account screen
     * @param inputs HashMap<String, String> oof the users inputs
     * @return true if all keys have a none empty string value
     */
    private boolean checkIfDone(HashMap<String, String> inputs) {
        for(int i = 0; i < options.size() - 2; i++) {
            if(inputs.get(options.get(i)) == ""){ return false; }
        }
        return true;
    }

    /**
     * Fills in the passport for a registered user
     * @param inputs HashTable<String, String> the inputs the user put in
     */
    private void fillOutPassport(HashMap<String, String> inputs) {
        String[] ans = new String[inputs.size() - 1];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = inputs.get(options.get(i));
        }
        Passport passport = new Passport(registeredUser.getUUID(), ans[0], ans[1], ans[2], ans[3], ans[4], ans[5], 
            ans[6], ans[7], new ArrayList<Airport>());
        registeredUser.addPassport(passport);
    }

    /**
     * Screen for the user to enter their username
     */
    private void loginScreen() {
        clear();
        System.out.println("********* Login **********\n");
        System.out.println("Enter Username:\n");
        String input = reader.nextLine();
        enterPasswordScreen(input);
    }

    /**
     * Screen for user to enter their paaword
     * @param username String of the users username
     */
    private void enterPasswordScreen(String username) {
        clear();
        System.out.println("********* Login **********\n");
        System.out.println("Enter Password:\n");
        String input = reader.nextLine();
        registeredUser = DataHandler.loadUser(username, input);
        clear();
        mainMenu();
    }

    /**
     * The screen that shows the users booking history
     */
    private void bookingHistoryScreen() {
        clear();
        System.out.println("******* My Bookings ******\n");
        if(registeredUser.getBookingHistory() != null){
            options = bookingHistoryOptions();
            printBookingHistoryOptions();
        }
        else {
            System.out.println("You have no booking History\n");
        }
        System.out.println("Enter 'Done' when done");
        readBookingHistory();
    }

    /**
     * fills out an ArrayList with the name of all the user's bookings
     * @return ArrayList<String>
     */
    private ArrayList<String> bookingHistoryOptions() {
        ArrayList<String> bookings = new ArrayList<String>();
        for(int i = 0; i < registeredUser.getBookingHistory().size(); i++) {
            bookings.add(registeredUser.getBookingHistory().get(i).getName());
        }
        return bookings;
    }

    /**
     * prints the options ArrayList when it is filled with the user's bookings
     */
    private void printBookingHistoryOptions() {
        for(int i = 0; i < options.size(); i++) {
            System.out.println((i+1) + ". " + options.get(i));
        }
    }

    /**
     * Reads the input on the booking history page
     */
    private void readBookingHistory() {
        boolean validInput = false;
        while(!validInput){
            String input = reader.nextLine();
            switch(input) {
                case "Done": case "done": validInput = true;
                    clear();
                    mainMenu();
                    break;
                default: System.out.println("Invalid input");
                    break;
            }
        }
    }

    /**
     * The user inputs their destination airport code
     */
    private void searchFlightScreen() {
        clear();
        System.out.println("***** Search Flight ******\n\nDestination Airport/ Airport Code:");
        String input = reader.nextLine();
        flightResultsScreen(input);
    }

    /**
     * Lists airports airports near the user and allows them to select one
     * @param airportCode String code for the destination airport
     */
    private void flightResultsScreen(String airportCode) {
        clear();
        System.out.println("***** Search Flight ******\n\nLocal Airports :");
        printLocalAirports();
        System.out.println("Enter Name of Departure airport or select option from above:");
        String input = reader.nextLine();
        dateOfFlightScreen(airportCode, input);
    }
    /**
     * prints a list of airports
     */
    private void printLocalAirports() {

    }

    /**
     * The user inputs the date they wish to fly
     * @param departureCode String
     * @param arrivalAirport String
     */
    private void dateOfFlightScreen(String departureCode, String arrivalAirport) {
        clear();
        System.out.println("***** Search Flight ******\n\nDate of Flight (mm/dd/yyyy):");
        String input = reader.nextLine();
        String[] inputs = input.split("/");
        int month = 0;
        int day = 0;
        int year = 0;
        try {
            month = Integer.parseInt(inputs[0]);
            day = Integer.parseInt(inputs[1]);
            year = Integer.parseInt(inputs[2]);
        }
        catch (NumberFormatException e) {
            dateOfFlightScreen(departureCode, arrivalAirport);

        }
        LocalDate departureDate = LocalDate.of(year, month, day);
        returnFlightScreen(departureCode, arrivalAirport, departureDate);
    }

    /**
     * Allows the user to input the return flight details
     * @param departureCode String
     * @param arrivalAirport String
     * @param departureDate LocalDate
     */
    private void returnFlightScreen(String departureCode, String arrivalAirport, LocalDate departureDate) {
        clear();
        System.out.println("***** Search Flight ******\n\nReturn Flight?(y/n)");
        boolean validInput = false;
        while(!validInput) {
            String input = reader.nextLine();
            switch(input) {
                case "y": validInput = true;
                    dateOfReturnFlightScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "n": validInput = true;
                flightResultScreen(departureCode, arrivalAirport, departureDate);
                    break;
                default: System.out.println("Invalid input");
                    break;

            }
        }
    }

    /**
     * Inputs the date of the return flight
     * @param departureCode String
     * @param arrivalAirport String
     * @param departureDate LocalDate
     */
    private void dateOfReturnFlightScreen(String departureCode, String arrivalAirport, LocalDate departureDate) {
        clear();
        System.out.println("***** Search Flight ******\n\nDate of Flight (mm/dd/yyyy):");
        String input = reader.nextLine();
        String[] inputs = input.split("/");
        int month = 0;
        int day = 0;
        int year = 0;
        try {
            month = Integer.parseInt(inputs[0]);
            day = Integer.parseInt(inputs[1]);
            year = Integer.parseInt(inputs[2]);
        }
        catch (NumberFormatException e) {
            dateOfReturnFlightScreen(departureCode, arrivalAirport, departureDate);

        }
        LocalDate arrivalDate = LocalDate.of(year, month, day);
        flightResultScreen(departureCode, arrivalAirport, departureDate, arrivalDate);
    }

    /**
     * Results for the return flight
     * @param departureCode String
     * @param arrivalAirport String
     * @param departureDate LocalDate
     * @param returnDate LocalDate
     */
    private void flightResultScreen(String departureCode, String arrivalAirport, LocalDate departureDate, LocalDate returnDate) {
        clear();
        System.out.println("********* Flight *********\n");
        printFlights(departureCode, arrivalAirport, departureDate);
        System.out.println("Add Filter? (y)\nDone? (done)\nChoose a Flight:");
        readFlightResults(departureCode, arrivalAirport, departureDate);
        flightResultScreen(departureCode, arrivalAirport, returnDate);
    }

    /**
     * Results for departing flights
     * @param departureCode String
     * @param arrivalAirport String
     * @param departureDate LocalDate
     */
    private void flightResultScreen(String departureCode, String arrivalAirport, LocalDate departureDate) {
        clear();
        System.out.println("********* Flight *********\n");
        printFlights(departureCode, arrivalAirport, departureDate);
        System.out.println("Add Filter? (y)\nDone? (done)\nChoose a Flight:");
        readFlightResults(departureCode, arrivalAirport, departureDate);
    }

    /**
     * Reads the users inputs from flight results
     * @param departureCode String
     * @param arrivalAirport String
     * @param departureDate LocalDate
     */
    private void readFlightResults(String departureCode, String arrivalAirport, LocalDate departureDate) {
        boolean validInput = false;
        while(!validInput) {
            String input = reader.nextLine();
            switch(input) {
                case "y" : validInput = true;
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "done" : case "Done" : case "DONE" : validInput = true;
                    chooseSeatScreen();
                    break;
                default : System.out.println("Invalid input");
            }
        }
    }

    /**
     * Prints all the flights
     * @param departureCode String
     * @param arrivalAirport String
     * @param flightDate LocalDate
     */
    private void printFlights(String departureCode, String arrivalAirport, LocalDate flightDate) {

    }

    /**
     * Lets the user choose a seat on the flight and books the flight
     */
    private void chooseSeatScreen() {
        clear();
        System.out.println("********* Flight *********\n");
        printSeats();
        System.out.println("Choose a Seat:");
        String input = reader.nextLine();
        clear();
        mainMenu();
    }

    /**
     * Prints the seats
     */
    private void printSeats() {

    }

    /**
     * Shows the filters for the flights
     * @param departureCode String
     * @param arrivalAirport String
     * @param departureDate LocalDate
     */
    private void filterScreen(String departureCode, String arrivalAirport, LocalDate departureDate) {
        clear();
        System.out.println("********* Filter *********\n\nFilters:");
        addFlightFilters();
        for(String option: options) {
            System.out.println(option);
        }
        System.out.println("\nEnter Option:");
        readFlightFilter(departureCode, arrivalAirport, departureDate);
    }

    /**
     * Adds all the filter options to options ArrayList<String>
     */
    private void addFlightFilters() {
        options.clear();
        options.add("1. Departure Time");
        options.add("2. Arrival Time");
        options.add("3. Filght Max Price");
        options.add("4. Number of Layovers");
        options.add("5. Total Layover Time");
        options.add("6. Total Flight Time");
        options.add("7. Seat Type");
        options.add("8. Airline");
        options.add("9. Rating");
        options.add("10. Done");
    }

    /**
     * Reads the users input from the filter screen
     * @param departureCode String
     * @param arrivalAirport String
     * @param departureDate LocalDate
     */
    private void readFlightFilter(String departureCode, String arrivalAirport, LocalDate departureDate) {
        boolean validInput = false;
        while(!validInput) {
            String input = reader.nextLine();
            switch(input) {
                case "1" : validInput = true;
                    flightFilter.setDepartureTime(Double.parseDouble(enterFilterValueScreen()));
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "2" : validInput = true;
                    flightFilter.setArrivalTime(Double.parseDouble(enterFilterValueScreen()));
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "3" : validInput = true;
                    flightFilter.setFlightPriceMax(Double.parseDouble(enterFilterValueScreen()));
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "4" :validInput = true;
                    flightFilter.setNumberOfLayovers(Integer.parseInt(enterFilterValueScreen()));
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "5" : validInput = true;
                    flightFilter.setTotalLayoverTime(Integer.parseInt(enterFilterValueScreen()));
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "6" : validInput = true;
                    flightFilter.setTotalFlightTime(Integer.parseInt(enterFilterValueScreen()));
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "7" : validInput = true;
                    flightFilter.setSeatType(enterFilterValueScreen());
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "8" : validInput = true;
                    airlines.add(enterFilterValueScreen());
                    flightFilter.setAirline(airlines);
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "9" : validInput = true;
                    flightFilter.setReview(Double.parseDouble(enterFilterValueScreen()));
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "10" : validInput = true;
                    flightResultScreen(departureCode, arrivalAirport, departureDate);
                    break;
                default : System.out.println("Invalid input");

            }
        }
    }

    /**
     * The user inputs their destination
     */
    private void searchHotelScreen() {
        clear();
        System.out.println("***** Search Hotel ******\n\nDestination:");
        String input = reader.nextLine();
        HotelResultsScreen(input);
    }

    /**
     * Lists hotels near the users destination and allows them to select one
     * @param destination String code for the destination airport
     */
    private void HotelResultsScreen(String destination) {
        clear();
        System.out.println("***** Search Hotel ******\n\nLocal Hotels :");
        printLocalHotels();
        System.out.println("Enter Name of hotel or select option from above:");
        String input = reader.nextLine();
        dateOfArrivalScreen(destination, input);
    }

    /**
     * The user inputs the date they wish to Arrive
     * @param departureCode String
     * @param arrivalAirport String
     */
    private void dateOfArrivalScreen(String destination, String hotel) {
        clear();
        System.out.println("***** Search Hotel ******\n\nDate of Arrival (mm/dd/yyyy):");
        String input = reader.nextLine();
        String[] inputs = input.split("/");
        int month = 0;
        int day = 0;
        int year = 0;
        try {
            month = Integer.parseInt(inputs[0]);
            day = Integer.parseInt(inputs[1]);
            year = Integer.parseInt(inputs[2]);
        }
        catch (NumberFormatException e) {
            dateOfArrivalScreen(destination, hotel);

        }
        LocalDate arrivalDate = LocalDate.of(year, month, day);
        dateOfDepartureScreen(destination, hotel, arrivalDate);
    }

    /**
     * The user inputs the date they wish to fly
     * @param departureCode String
     * @param arrivalAirport String
     */
    private void dateOfDepartureScreen(String destination, String hotel, LocalDate arrivalDate) {
        clear();
        System.out.println("***** Search Hotel ******\n\nDate of Departure (mm/dd/yyyy):");
        String input = reader.nextLine();
        String[] inputs = input.split("/");
        int month = 0;
        int day = 0;
        int year = 0;
        try {
            month = Integer.parseInt(inputs[0]);
            day = Integer.parseInt(inputs[1]);
            year = Integer.parseInt(inputs[2]);
        }
        catch (NumberFormatException e) {
            dateOfDepartureScreen(destination, hotel, arrivalDate);

        }
        LocalDate departureDate = LocalDate.of(year, month, day);
        HotelResultScreen(destination, hotel, arrivalDate, departureDate);
    }

    /**
     * Results for departing flights
     * @param departureCode String
     * @param arrivalAirport String
     * @param departureDate LocalDate
     */
    private void HotelResultScreen(String destination, String hotel, LocalDate arrivalDate, LocalDate departureDate) {
        clear();
        System.out.println("********* Flight *********\n");
        printHotels(destination, hotel, arrivalDate, departureDate);
        System.out.println("Add Filter? (y)\nDone? (done)\nChoose a Flight:");
        readHotelResults(destination, hotel, arrivalDate, departureDate);
    }

    /**
     * Reads the users inputs from flight results
     * @param departureCode String
     * @param arrivalAirport String
     * @param departureDate LocalDate
     */
    private void readHotelResults(String destination, String hotel, LocalDate arrivalDate, LocalDate departureDate) {
        boolean validInput = false;
        while(!validInput) {
            String input = reader.nextLine();
            switch(input) {
                case "y" : validInput = true;
                    filterScreen(destination, hotel, arrivalDate, departureDate);
                    break;
                case "done" : case "Done" : case "DONE" : validInput = true;
                    chooseSeatScreen();
                    break;
                default : System.out.println("Invalid input");
            }
        }
    }

    /**
     * Shows the filters for the flights
     * @param departureCode String
     * @param arrivalAirport String
     * @param departureDate LocalDate
     */
    private void filterScreen(String destination, String hotel, LocalDate arrivalDate, LocalDate departureDate) {
        clear();
        System.out.println("********* Filter *********\n\nFilters:");
        addHotelFilters();
        for(String option: options) {
            System.out.println(option);
        }
        System.out.println("\nEnter Option:");
        readHotelFilter(destination, hotel, arrivalDate, departureDate);
    }

    /**
     * Prints all the flights
     * @param departureCode String
     * @param arrivalAirport String
     * @param flightDate LocalDate
     */
    private void printHotels(String destination, String hotel, LocalDate arrivalDate, LocalDate departureDate) {

    }

    /**
     * Adds all the filter options to options ArrayList<String>
     */
    private void addHotelFilters() {
        options.clear();
        options.add("1. Departure Date");
        options.add("2. Arrival Date");
        options.add("3. Hotel Max Price");
        options.add("4. Pool");
        options.add("5. Smoking");
        options.add("6. One Bed");
        options.add("7. Two Bed");
        options.add("8. Hotel");
        options.add("9. Rating");
        options.add("10. Done");
    }

    /**
     * Reads the users input from the filter screen
     * @param departureCode String
     * @param arrivalAirport String
     * @param departureDate LocalDate
     */
    private void readHotelFilter(String destination, String hotel, LocalDate arrivalDate, LocalDate departureDate) {
        boolean validInput = false;
        while(!validInput) {
            String input = reader.nextLine();
            switch(input) {
                case "1" : validInput = true;
                    hotelFilter.setArrivalDate(arrivalDate);
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "2" : validInput = true;
                    hotelFilter.setDepartureDate(departureDate);
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "3" : validInput = true;
                    hotelFilter.setFlightPriceMax(Double.parseDouble(enterFilterValueScreen()));
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "4" :validInput = true;
                    hotelFilter.setNumberOfLayovers(Integer.parseInt(enterFilterValueScreen()));
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "5" : validInput = true;
                    hotelFilter.setTotalLayoverTime(Integer.parseInt(enterFilterValueScreen()));
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "6" : validInput = true;
                    hotelFilter.setTotalFlightTime(Integer.parseInt(enterFilterValueScreen()));
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "7" : validInput = true;
                    hotelFilter.setSeatType(enterFilterValueScreen());
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "8" : validInput = true;
                    airlines.add(enterFilterValueScreen());
                    hotelFilter.setAirline(airlines);
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "9" : validInput = true;
                    hotelFilter.setReview(Double.parseDouble(enterFilterValueScreen()));
                    filterScreen(departureCode, arrivalAirport, departureDate);
                    break;
                case "10" : validInput = true;
                    flightResultScreen(departureCode, arrivalAirport, departureDate);
                    break;
                default : System.out.println("Invalid input");

            }
        }
    }
    /**
     * Allows the user input a value for the filter
     * @return String of the users input
     */
    private String enterFilterValueScreen() {
        System.out.println("********* Filter *********\n\nEnter value:");
        String input = reader.nextLine();
        return input;
    }

    /**
     * clears the terminal, from Command Design
     */
    private void clear() {
        System.out.print("\033[H\033[2J");
    }
    
}
