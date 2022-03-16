package express;

import java.time.LocalTime;
import java.util.HashMap;

/**
 * Holds the information of a given flight
 * @author Miller Banford
 * @version 1.0.0
 */
public class Flight extends BookableEntity {

    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int departureCode;
    
    private int arrivalCode;
    private int totalSeats;
    private HashMap<String, Boolean> mapFlightSeats;

    /**
     * Constructer for a flight
     */
    public Flight(LocalTime departurTime, LocalTime arrivalTime, int departureCode, int arrivalCode, int totalSeats, HashMap<String, Boolean> mapFlightSeats) {

        this.departureTime = departurTime;
        this.arrivalTime = arrivalTime;
        this.departureCode = departureCode;
        this.arrivalCode = arrivalCode;
        this.totalSeats = totalSeats;
        this.mapFlightSeats = mapFlightSeats;

    }

    /**
     * Constructer for a flight
     */
    public Flight(int flightId, int departureCode, int totalSeats) {

    }

    /**
     * gets the departure time for the flight
     * @return LocalTime departureTime
     */
    public LocalTime getDepartureTime() { return departureTime; }
    /**
     * gets the arrival time for the flight
     * @return LocalTime arrivalTime
     */
    public LocalTime getArrivalTime() { return arrivalTime; }
    /**
     * gets the departure code for the flight
     * @return int departureCode
     */
    public int getDepartureCode() { return departureCode; }
    /**
     * gets the arrival code for the flight
     * @return int arrivalCode
     */
    public int getArrivalCode() { return arrivalCode; }
    /**
     * gets the total number of seats for the flight
     * @return int totalSeats
     */
    public int getTotalSeats() { return totalSeats; }
    /**
     * gets the HashMap of the flights seats containg a String name for the seat and a boolean is the seat is booked or not for the flight
     * @return HashMap<String, Boolean> mapFlightSeats
     */
    public HashMap<String, Boolean> getMapFlightSeats() { return mapFlightSeats; }
    
    
}
