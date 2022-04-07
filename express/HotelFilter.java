// package express;
import java.time.LocalDate;
import java.util.*;
/**
 * Thomas Ferguson
 */
public class HotelFilter {
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private double hotelPriceMax;
    private int numBeds;
    private boolean smoking;
    private boolean pool;
    private double review;
    private String location;
    ArrayList<String> hotels;
/**
 * Constructor for Hotel Filter
 */
    public HotelFilter(){
        arrivalDate = LocalDate.of(9999, 12, 31);
        departureDate = LocalDate.of(9999, 12, 31);
        hotelPriceMax = 0.0;
        review = 0.0;
        location = "No Location";
        numBeds = 0;
        smoking = true;
        pool = true;
    }
/**
 * Accessor for arrival date
 * @return the date of arrival
 */
    public LocalDate getArrivalDate() {
        return arrivalDate;
    }
/**
 * Mutator for arrival date
 * @param arrivalDate passes arrivalDate variable in
 */
    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
/**
 * Accessor for the departure date
 * @return the date of departure
 */
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public double getMaxPrice() {
        return hotelPriceMax;
    }

    public double getReview() {
        return review;
    }

    public void setReview(double reviews) {
        this.review = reviews;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public double getHotelPriceMax() {
        return hotelPriceMax;
    }
    public void setHotelPriceMax(double hotelPriceMax) {
        this.hotelPriceMax = hotelPriceMax;
    }
    public int getNumBeds() {
        return numBeds;
    }
    public void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
    }
    public boolean isSmoking() {
        return smoking;
    }
    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }
    public boolean isPool() {
        return pool;
    }
    public void setPool(boolean pool) {
        this.pool = pool;
    }
    public ArrayList<String> getHotels() {
        return hotels;
    }
    public void setHotels(ArrayList<String> hotels) {
        this.hotels = hotels;
    }

    
    
}
