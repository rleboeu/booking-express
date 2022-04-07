// package express;
import java.time.*;
import java.util.ArrayList;
/**
 * Thomas Ferguson
 */
public class FlightFilter {
    private double departureTime;
    private LocalDate departureDate;
    private String departureAirportCode;
    private double arrivalTime;
    private LocalDate arrivalDate;
    private String arrivalAirportCode;
    private double flightPriceMax;
    private int numberOfLayovers;
    private int totalLayoverTime;
    private int totalFlightTime;
    private String seatType;
    private ArrayList<String> airline;
    private double review;
/**
 * Flight filter constructor
 */
    public FlightFilter(){
        departureTime = 0.0;
        departureDate = LocalDate.of(9999,12,31);
        departureAirportCode = "HM887890";
        arrivalTime = 0.0;
        arrivalDate = LocalDate.of(9999,12,31);
        arrivalAirportCode = "HM887890";
        flightPriceMax = 0.0;
        numberOfLayovers = 0;
        totalLayoverTime = 0;
        totalFlightTime = 0;
        seatType = "No type";
        review = 0.0;
    }

    /**
     * Accessor that gets the departure time
     * @return the departure time
     */
    public double getDepartureTime() { return departureTime; }
    /**
     * Mutator that sets the departure time
     * @param departureTime Passes the departureTime variable in
     */
    public void setDepartureTime(double departureTime) { this.departureTime = departureTime; }
    /**
     * Accessor that gets time of arrival
     * @return the arrival time
     */
    public double getArrivalTime() { return arrivalTime; }
    /**
     * Mutator that sets the arrival time
     * @param arrivalTime passes the arrivalTime variable in
     */
    public void setArrivalTime(double arrivalTime) { this.arrivalTime = arrivalTime; }
    /**
     * Accessor for the maximum flight price
     * @return the maximum flight price
     */
    public double getFlightPriceMax() { return flightPriceMax; }
    /**
     * Mutator that sets the maximum flight price
     * @param flightPriceMax passes the flightPriceMax variable in
     */
    public void setFlightPriceMax(double flightPriceMax) { this.flightPriceMax = flightPriceMax; }
    /**
     * Accessor for the number of layovers
     * @return the number of layovers
     */
    public int getNumberOfLayovers() { return numberOfLayovers; }
    /**
     * Mutator that sets the number of layovers
     * @param numberOfLayovers passes the numberOfLayovers variable in
     */
    public void setNumberOfLayovers(int numberOfLayovers) { this.numberOfLayovers = numberOfLayovers; }
    /**
     * Accessor for the total layover time
     * @return the total amount of layover time
     */
    public int getTotalLayoverTime() { return totalLayoverTime; }
    /**
     * Mutator for the total layover time
     * @param totalLayoverTime passes the totalLayoverTime variable in
     */
    public void setTotalLayoverTime(int totalLayoverTime) { this.totalLayoverTime = totalLayoverTime; }
    /**
     * Accessor for the total flight time
     * @return the total amount of flight time
     */
    public int getTotalFlightTime() { return totalFlightTime; }
    /**
     * Mutator for the total amount of flight time
     * @param totalFlightTime passes the totalFlightTime variable in
     */
    public void setTotalFlightTime(int totalFlightTime) { this.totalFlightTime = totalFlightTime; }
    /**
     * Accessor for the type of seat
     * @return the seat type
     */
    public String getSeatType() { return seatType; }
    /**
     * Mutator for setting the seat type
     * @param seatType passes the seatType variable in
     */
    public void setSeatType(String seatType) { this.seatType = seatType; }
    /**
     * Accessor for getting the airline
     * @return the airline 
     */
    public ArrayList<String> getAirline() { return airline; }
    /**
     * Mutator for setting the airline
     * @param airline passes the airline variable in
     */
    public void setAirline(ArrayList<String> airline) { this.airline = airline; }
    /**
     * Accessor for getting the review variable
     * @return the review
     */
    public double getReview() { return review; }
    /**
     * Mutator for setting the review variable
     * @param review passes the review variable in
     */
    public void setReview(double review) { this.review = review; }

    /**
     * Sets the departure date
     * @param departureDate LocalDate
     */
    public void setDepartureDate(LocalDate departureDate) { this.departureDate = departureDate; }

    /**
     * Sets the departure airport code
     * @param departureDate String
     */
    public void setDepartureAirport(String departureAirportCode) { this.departureAirportCode = departureAirportCode;}
}
