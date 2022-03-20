package express;

import java.util.ArrayList;
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

    /**
     * Constructer
     */
    private ConsoleBookingExpress() {
        System.out.println("Welcome to Booking Express!\n");
        user = new User("");
        registeredUser = null;
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
                    break;
                case "5": validInput = true;
                    if(registeredUser == null) { createAccoutnScreen();}
                    break;
                default: System.out.println("Invalid input");
                    break;
            }
        }
    }

    /**
     * prints the Account Creation screen and waits for user input
     */
    private void createAccoutnScreen() {
        clear();
        System.out.println("***** Create Account *****");
        addCreateAccountOptions();
        printOptions();
        System.out.println("What would you like to do?\n");
        readCreateAccountInput();
    }

    private void addCreateAccountOptions() {
        options.clear();
        options.add("1. First Name");
        options.add("2. Last Name");
        options.add("3. Date of Birth");
        options.add("4. Nationality");
        options.add("5. Place of Birth");
        options.add("6. Sex");
        options.add("7. Issue Date");
        options.add("8. Expiration Date");
        options.add("9. Passport Number");
        options.add("10. Done");
    }

    /**
     * Reads the input from the user on the create account and takes them to the next selected screen
     */
    private void readCreateAccountInput() {
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
                    break;
                case "5": validInput = true;
                    if(registeredUser == null) { createAccoutnScreen();}
                    break;
                case "6": validInput = true;
                    break;
                case "7": validInput = true;
                    break;
                case "8": validInput = true;
                    break;
                case "9": validInput = true;
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
     * clears the terminal, from Command Design
     */
    private void clear() {
        System.out.print("\033[H\033[2J");
    }
    
}
