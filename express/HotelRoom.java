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
    private ArrayList<Review> reviews;
/**
 * Constructor for HotelRoom
 * @param availabilityStart Initializes the date of the hotel availability
 * @param availabilityEnd Initializes the date of the hotel availabilities end
 * @param reviews Initializes arraylist of reviews
 */
    public HotelRoom(LocalDate availabilityStart, LocalDate availabilityEnd, ArrayList<Review> reviews){
        this.availabilityStart = availabilityStart;
        this.availabilityEnd = availabilityEnd;
        numBeds = 0;
        this.reviews = reviews;
    }
}
