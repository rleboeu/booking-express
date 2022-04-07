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
/**
 * Constructor for car filter
 */
    public CarFilter(){
        departureDate = null;
        arrivalDate = null;
        carPriceMax = 0.0;
        review = 0.0;
        style = null;
        location = "None";
    }
/**
 * Accessor for getting departure date
 */
    public LocalDate getDepartureDate() {
        return departureDate;
    }
/**
 * Mutator for setting the departure date
 * @param departureDate
 */
    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
/**
 * accessor for getting the arrival date
 * @return the arrival date
 */
    public LocalDate getArrivalDate() {
        return arrivalDate;
    }
/**
 * Mutator for setting the arrival date
 * @param arrivalDate the arrival date 
 */
    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
/**
 * Accessor for getting the car price
 * @return the car price
 */
    public double getCarPriceMax() {
        return carPriceMax;
    }
/**
 * Mutator for setting the car price
 * @param carPriceMax the maximum car price
 */
    public void setCarPriceMax(double carPriceMax) {
        this.carPriceMax = carPriceMax;
    }
/**
 * Accessor for getting the review
 * @return the review
 */
    public double getReview() {
        return review;
    }
/**
 * Mutator for setting the review
 * @param review the review
 */
    public void setReview(double review) {
        this.review = review;
    }
/**
 * Accessor for getting the style
 * @return the style of car
 */
    public CarStyle getStyle() {
        return style;
    }
/**
 * mutator for setting the style
 * @param style the style of car
 */
    public void setStyle(CarStyle style) {
        this.style = style;
    }
/**
 * Accessor for getting the location
 * @return the location
 */ 
    public String getLocation() {
        return location;
    }
/**
 * 
 * @param location
 */
    public void setLocation(String location) {
        this.location = location;
    }
    
}
