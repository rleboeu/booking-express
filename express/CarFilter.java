package express;
import java.time.*;
/**
 * Thomas Ferguson
 */
public class CarFilter {
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private double carPriceMax;
    private double review;
    private CarStyle style;
    private String location;

    public CarFilter(){
        departureDate = null;
        arrivalDate = null;
        carPriceMax = 0.0;
        review = 0.0;
        style = null;
        location = "None";
    }
    
}