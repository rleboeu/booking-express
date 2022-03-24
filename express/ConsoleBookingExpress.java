package express;

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
        options.add("9. Done");
        options.add("10. Exit");
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
        input.put(options.get(8), "Done");
        input.put(options.get(9), "Exit");
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
                    if(checkIfDone(inputs)) {
                        registeredUser = user.createAccoutn(inputs.get("1. First Name"), inputs.get("2. Last Name"), 
                            inputs.get("3. Date of Birth"));
                        fillOutPassport(inputs);
                        clear();
                        mainMenu();
                    }
                    else {
                        createAccoutnScreen(true);
                    }
                    break;
                case "10": validInput = true;
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
            ans[6], ans[7], registeredUser.getBookingHistory());
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
     * clears the terminal, from Command Design
     */
    private void clear() {
        System.out.print("\033[H\033[2J");
    }
    
}
