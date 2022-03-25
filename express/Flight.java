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
    private int departureCode;
    private int arrivalCode;
    private int totalSeats;
    private boolean[][] seatMap;

    /**
     * Flight constructor
     * @param id UUID 
     * @param departureTime String
     * @param arrivalTime String
     * @param departureCode int
     * @param arrivalCode int
     * @param seatMap boolean[][]
     * @param reviews ArrayList<Review>
     */
    public Flight(UUID uuid, String name, double price, boolean available, String departureTime, String arrivalTime, int departureCode, int arrivalCode, boolean[][] seatMap, ArrayList<Review> reviews) {
        super(uuid, name, price, available, reviews);
        this.departureTime = LocalTime.parse(departureTime);
        this.arrivalTime = LocalTime.parse(arrivalTime);
        this.departureCode = departureCode;
        this.arrivalCode = arrivalCode;
        this.seatMap = seatMap;
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
     * Returns a String representation of the seats on the flight
     * @return String
     */
    public String getSeatMap() {
        StringBuffer sb = new StringBuffer();
        char a = 'A';

        for (int row = 0; row < this.seatMap.length; ++row) {
            for (int col = 0; col < this.seatMap[row].length; ++col) {
                sb.append(a + row); // seat letter
                sb.append(col + ":");     // seat number
                sb.append(this.seatMap[row][col] + " ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
    
    
}
