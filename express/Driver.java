package express;

/**
 * Drives the application
 * @author Miller Banford
 * @version 1.0.0
 */
public class Driver {

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.run();
    }

    public void run() {
        ConsoleBookingExpress consoleBookingExpress = ConsoleBookingExpress.getInstantsConsoleBookingExpress();
        consoleBookingExpress.mainMenu();
    }
    
}
