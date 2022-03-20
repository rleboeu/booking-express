package express;
import java.util.*;
import java.time.*;
/**
 * Thomas Ferguson
 */
public class RentalCar extends BookableEntity {
    private CarStyle style;
    private ArrayList<CarFeature> features;
    private LocalDate startDay;
    private LocalDate endDay;
    private int numSeats;

    public RentalCar(CarStyle style, ArrayList<CarFeature> features, LocalDate startDay, LocalDate endDay, int numSeats){
    this.style = style;
    this.features = features;
    this.startDay = startDay;
    this.startDay = startDay;
    this.endDay = endDay;
    this.numSeats = numSeats;
    }
}
