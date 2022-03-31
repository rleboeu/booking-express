package express;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Holds the information of a given flight
 * @author Miller Banford, Ryan LeBoeuf
 * @version 1.0.0
 */
public class Flight extends BookableEntity {

    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private int totalSeats;
    private ArrayList<ArrayList<Boolean>> seatMap;

    /**
     * Flight constructor
     * @param id UUID 
     * @param departureTime String
     * @param arrivalTime String
     * @param departureAirport Airport
     * @param arrivalAirport Airport
     * @param seatMap boolean[][]
     * @param reviews ArrayList<Review>
     */
    public Flight(UUID uuid, String name, double price, boolean available, String departureTime, String arrivalTime, Airport departureAirport, Airport arrivalAirport, ArrayList<ArrayList<Boolean>> seatMap, ArrayList<Review> reviews) {
        super(uuid, name, price, available, reviews);

        this.departureTime = LocalTime.parse(departureTime);
        this.arrivalTime = LocalTime.parse(arrivalTime);
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.seatMap = seatMap;
        isAFlight = true;
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
     * gets the departure Airport for the flight
     * @return Airport departureAirport
     */
    public Airport getDepartureCode() { return departureAirport; }
    /**
     * gets the arrival Airport for the flight
     * @return Airport arrivalAirport
     */
    public Airport getArrivalCode() { return arrivalAirport; }
    /**
     * gets the total number of seats for the flight
     * @return int totalSeats
     */
    public int getTotalSeats() { return totalSeats; }
    
    /**
     * Returns the raw 2D boolean array of the seat map
     * @return boolean[][]
     */
    public ArrayList<ArrayList<Boolean>> getSeatMapRaw() {
        return this.seatMap;
    }

    /**
     * Returns a String representation of the seats on the flight
     * @return String
     */
    public String getSeatMapString() {
        StringBuffer sb = new StringBuffer();
        char a = 'A';

        for (int row = 0; row < this.seatMap.size(); ++row) {
            for (int col = 0; col < this.seatMap.get(row).size(); ++col) {
                sb.append(a + row); // seat letter
                sb.append(col + ":");     // seat number
                sb.append(this.seatMap.get(row).get(col) + " ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
    
    
}
