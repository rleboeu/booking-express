package express;
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

    public FlightFilter(){
        departureTime = 0.0;
        departureDate = LocalDate.of(2022,03,17);
        departureAirportCode = "HM887890";
        arrivalTime = 0.0;
        arrivalDate = LocalDate.of(2022,03,17);
        arrivalAirportCode = "HM887890";
        flightPriceMax = 0.0;
        numberOfLayovers = 0;
        totalLayoverTime = 0;
        totalFlightTime = 0;
        seatType = "No type";
        review = 0.0;
    }

    /**
     * 
     * @return
     */
    public double getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(double departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public double getFlightPriceMax() {
        return flightPriceMax;
    }

    public void setFlightPriceMax(double flightPriceMax) {
        this.flightPriceMax = flightPriceMax;
    }

    public int getNumberOfLayovers() {
        return numberOfLayovers;
    }

    public void setNumberOfLayovers(int numberOfLayovers) {
        this.numberOfLayovers = numberOfLayovers;
    }

    public int getTotalLayoverTime() {
        return totalLayoverTime;
    }

    public void setTotalLayoverTime(int totalLayoverTime) {
        this.totalLayoverTime = totalLayoverTime;
    }

    public int getTotalFlightTime() {
        return totalFlightTime;
    }

    public void setTotalFlightTime(int totalFlightTime) {
        this.totalFlightTime = totalFlightTime;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public ArrayList<String> getAirline() {
        return airline;
    }

    public void setAirline(ArrayList<String> airline) {
        this.airline = airline;
    }

    public double getReview() {
        return review;
    }

    public void setReview(double review) {
        this.review = review;
    }
}
