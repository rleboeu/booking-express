package express;
import java.time.*;
import java.util.ArrayList;
/**
 * Thomas Ferguson
 */
public class FlightFilter {
    private int departureTime;
    private LocalDate departureDate;
    private String departureAirportCode;
    private int arrivalTime;
    private LocalDate arrivalDate;
    private String arrivalAirportCode;
    private double flightPriceMax;
    private int numberOfLayovers;
    private int totalLayoverTime;
    private int totalFlightTime;
    private String seatType;
    private ArrayList<String> airline;
    private double review;

    public FlightFilter(){
        
    }
}
