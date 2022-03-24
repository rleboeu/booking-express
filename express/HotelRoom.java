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
/**
 * Accessor for getting the start of availability
 * @return The Local Date of when the availability starts
 */
public LocalDate getAvailabilityStart() {
    return availabilityStart;
}
/**
 * Mutator for setting the start of availability
 * @param availabilityStart 
 */
public void setAvailabilityStart(LocalDate availabilityStart) {
    this.availabilityStart = availabilityStart;
}
/**
 * Accessor for getting the end of availability for a hotel room
 * @return Thew end of availability
 */
public LocalDate getAvailabilityEnd() {
    return availabilityEnd;
}
/**
 * Mutator for setting the end of availability
 * @param availabilityEnd
 */
public void setAvailabilityEnd(LocalDate availabilityEnd) {
    this.availabilityEnd = availabilityEnd;
}
/**
 * Accessor for getting reviews
 * @return The reviews arraylist
 */
public ArrayList<Review> getReviews() {
    return reviews;
}
/**
 * Adds a review to the reviews arraylist
 * @param review
 */
public void addReviews(Review review) {
    reviews.add(review);
}
    
}
