package express;
import java.time.*;
/**
 * Thomas Ferguson
 */


public class HotelFilter {
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private double price;
    private double reviews;
    private String location;

    public HotelFilter(){
        arrivalDate = new LocalDate(2022, 03, 17);
        departureDate = LocalDate.now();
        price = 0.0;
        reviews = 0.0;
        location = "No Location";
    }
}