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
    /**
     * Constructor for rental car
     * @param id The UUID of the rental car
     * @param name the name of the rental car
     * @param price the price of the rental car
     * @param available the availability of rental car
     * @param style the style of rental car
     * @param features the features of the rental car
     * @param startDay the start day of renting
     * @param endDay the end day of renting
     * @param numSeats the number of seats in the rented car
     * @param reviews the reviews of the rental car
     */
    public RentalCar(UUID id, String name, double price, boolean available, CarStyle style, ArrayList<CarFeature> features, LocalDate startDay, LocalDate endDay, int numSeats, ArrayList<Review> reviews){
        super(id, name, price, available, reviews);
        this.style = style;
        this.features = features;
        this.startDay = startDay;
        this.startDay = startDay;
        this.endDay = endDay;
        this.numSeats = numSeats;
    }
    /**
     * Gets the style of the rental car
     * @return the style
     */
    public CarStyle getStyle() {
        return style;
    }
    /**
     * Sets the style of the rental car
     * @param style
     */
    public void setStyle(CarStyle style) {
        this.style = style;
    }
    /**
     * Gets the features of the rental car
     * @return the features of the rental car
     */
    public ArrayList<CarFeature> getFeatures() {
        return features;
    }
    /**
     * Sets the features of the rental car
     * @param features 
     */
    public void setFeatures(ArrayList<CarFeature> features) {
        this.features = features;
    }
    /**
     * Gets the start day of the rental
     * @return
     */
    public LocalDate getStartDay() {
        return startDay;
    }
    /**
     * Sets the start day of the rental
     * @param startDay
     */
    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }
    /**
     * Gets the end day of the rental
     * @return the end day
     */
    public LocalDate getEndDay() {
        return endDay;
    }
    /**
     * Sets the end day of the rental
     * @param endDay
     */
    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }
    /**
     * Gets the number of seats of the rental
     * @return
     */
    public int getNumSeats() {
        return numSeats;
    }
    /**
     * Sets the number of seats of the rental
     * @param numSeats
     */
    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
    
}
