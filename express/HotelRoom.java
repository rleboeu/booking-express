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

    public HotelRoom(LocalDate availabilityStart, LocalDate availabilityEnd, ArrayList<Review> reviews){
        this.availabilityStart = availabilityStart;
        this.availabilityEnd = availabilityEnd;
        this.numBeds = numBeds;
    }
}
