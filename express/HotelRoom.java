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
    private Airport nearAirportCode;
    private ArrayList<Review> reviews;
    /**
     * Constructor for HotelRoom
     * @param nearAirportCode Initializes the nearby airport code
     * @param availabilityStart Initializes the date of the hotel availability
     * @param availabilityEnd Initializes the date of the hotel availabilities end
     * @param reviews Initializes arraylist of reviews
     */
        public HotelRoom(UUID uuid, String name, double price, boolean available, int numBeds, Airport nearAirportCode, LocalDate availabilityStart, LocalDate availabilityEnd, ArrayList<Review> reviews){
            super(uuid, name, price, available, reviews);
            this.availabilityStart = availabilityStart;
            this.availabilityEnd = availabilityEnd;
            this.reviews = reviews;
            this.nearAirportCode = nearAirportCode;
            this.numBeds = numBeds;
            isAHotel = true;
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
    /**
     * Gets the number of beds
     * @return the number of beds
     */
    public int getNumBeds() {
        return numBeds;
    }
    /**
     * Sets the number of beds
     * @param numBeds the number of beds
     */
    public void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
    }
    /**
     * Gets the airport code
     * @return the airport code
     */
    public Airport getNearAirportCode() {
        return nearAirportCode;
    }
    /**
     * Sets the airport code
     * @param nearAirportCode the airport code
     */
    public void setNearAirportCode(Airport nearAirportCode) {
        this.nearAirportCode = nearAirportCode;
    }
    
}
