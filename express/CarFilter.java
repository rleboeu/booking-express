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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public double getCarPriceMax() {
        return carPriceMax;
    }

    public void setCarPriceMax(double carPriceMax) {
        this.carPriceMax = carPriceMax;
    }

    public double getReview() {
        return review;
    }

    public void setReview(double review) {
        this.review = review;
    }

    public CarStyle getStyle() {
        return style;
    }

    public void setStyle(CarStyle style) {
        this.style = style;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
}
