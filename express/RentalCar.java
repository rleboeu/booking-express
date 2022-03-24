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

    public CarStyle getStyle() {
        return style;
    }

    public void setStyle(CarStyle style) {
        this.style = style;
    }

    public ArrayList<CarFeature> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<CarFeature> features) {
        this.features = features;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
    
}
