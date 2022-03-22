package express;
import java.time.*;
import java.util.*;
/**
 * Thomas Ferguson
 */
public class HotelRoom extends BookableEntity {
    private LocalDate availabilityStart;
    private LocalDate availabilityEnd;
    private int numBeds;
    private int nearAirportCode;
    private ArrayList<Review> reviews;
/**
 * Constructor for HotelRoom
 * @param nearAirportCode Initializes the nearby airport code
 * @param availabilityStart Initializes the date of the hotel availability
 * @param availabilityEnd Initializes the date of the hotel availabilities end
 * @param reviews Initializes arraylist of reviews
 */
    public HotelRoom(int nearAirportCode, LocalDate availabilityStart, LocalDate availabilityEnd, ArrayList<Review> reviews){
        this.availabilityStart = availabilityStart;
        this.availabilityEnd = availabilityEnd;
        this.reviews = reviews;
        this.nearAirportCode = nearAirportCode;
    }
public LocalDate getAvailabilityStart() {
    return availabilityStart;
}
public void setAvailabilityStart(LocalDate availabilityStart) {
    this.availabilityStart = availabilityStart;
}
public LocalDate getAvailabilityEnd() {
    return availabilityEnd;
}
public void setAvailabilityEnd(LocalDate availabilityEnd) {
    this.availabilityEnd = availabilityEnd;
}
public int getNumBeds() {
    return numBeds;
}
public void setNumBeds(int numBeds) {
    this.numBeds = numBeds;
}
public int getNearAirportCode() {
    return nearAirportCode;
}
public void setNearAirportCode(int nearAirportCode) {
    this.nearAirportCode = nearAirportCode;
}
public ArrayList<Review> getReviews() {
    return reviews;
}
public void setReviews(ArrayList<Review> reviews) {
    this.reviews = reviews;
}
    
}
