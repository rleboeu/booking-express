// Not working... yet!
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ConsoleBookingExpressTest  {
//TODO Most methods within this class are private so will need to mock them
//Not sure if we actually need to test an output so commented out
/*
private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
private final PrintStream originalOut = System.out;
private final PrintStream originalErr = System.err;

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
    
    @Test
    public void testMainMenuErr(){
        System.err.print("Main menu changed");
        assertEquals("******* Main Menu ********\n", errContent.toString());
    }
*/
//        System.out.println("******* Main Menu ********\n");
//        addMainMenuOptions();
//        printOptions();
//        System.out.println("What would you like to do?\n");
//        readMainMenuInput();

}

