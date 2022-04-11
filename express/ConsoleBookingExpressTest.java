// Not working... yet!
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertArrayEquals;
/**
 * @author Thomas Ferguson
 */
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ConsoleBookingExpressTest  {
//TODO Most methods within this class are private so will need to mock them
//Not sure if we actually need to test an output so commented out

private static final RegisteredUser registeredUser = null;
private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
private final PrintStream originalOut = System.out;
private final PrintStream originalErr = System.err;
private ArrayList<String> options;
private ConsoleBookingExpressTest inputs;
private Scanner reader;
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    
    public void testMainMenuOut(){
        
        System.out.println("******* Main Menu ********\n");
        assertEquals("******* Main Menu ********\n", outContent.toString());
        System.out.println("What would you like to do?\n");
        assertEquals("What would you like to do?\n", errContent.toString());
        
    }
    @Test
    public void testMainMenuErr(){
        System.err.print("Main menu changed");
        assertEquals("******* Main Menu ********\n", errContent.toString());
    }
    @Test
    public void testPrintOptions(){
        for(String option: options) {
            System.out.println(option +"\n");
        }
    }
    @Test
    public void testReadMainMenu(){
        boolean validInput = false;
        while(!validInput){
            String input = reader.nextLine();
            RegisteredUser registeredUser = this.registeredUser;
            switch(input) {
                case "1": validInput = true;
                    searchFlightScreen();
                    break;
                case "2": validInput = true;
                    searchHotelScreen();
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
    @Test
    public void testCreateAccoutnScreen(boolean hasHashMap)
    {
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
    @Test
    public void testFillHashmap(){
        HashMap<String,String> input = new HashMap<String, String>();
        for(String option: options) {
            input.put(option, "");
        }
        input.put(options.get(9), "Done");
        input.put(options.get(10), "Exit");
        return;
    }
    @Test
    public void testPrintOptionsWithHashMap(HashMap<String, String> input){
        for(int i = 0; i < options.size() - 2; i++) {
            System.out.println(options.get(i) + ": " + input.get(options.get(i)));
        }
        System.out.println(options.get(8));
        System.out.println(options.get(9));
        System.out.println("\n");
    }
    private void readCreateAccountInput(ConsoleBookingExpressTest inputs) {
    }

    private void printOptionsWithHashMap(ConsoleBookingExpressTest inputs) {
    }

    private ConsoleBookingExpressTest fillHashmap() {
        return null;
    }

    private void addCreateAccountOptions() {
    }

    private void bookingHistoryScreen() {
    }

    private void createAccoutnScreen(boolean b) {
    }

    private void loginScreen() {
    }

    private void mainMenu() {
    }

    private void clear() {
    }

    private void searchHotelScreen() {
    }

    private void searchFlightScreen() {
    }

}

