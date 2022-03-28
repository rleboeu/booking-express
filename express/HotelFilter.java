package express;
import java.time.LocalDate;
/**
 * Thomas Ferguson
 */
public class HotelFilter {
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private double price;
    private double reviews;
    private String location;
/**
 * Constructor for Hotel Filter
 */
    public HotelFilter(){
        arrivalDate = LocalDate.of(9999, 12, 31);
        departureDate = LocalDate.of(9999, 12, 31);
        price = 0.0;
        reviews = 0.0;
        location = "No Location";
    }
/**
 * Accessor for arrival date
 * @return the date of arrival
 */
    public LocalDate getArrivalDate() {
        return arrivalDate;
    }
/**
 * Mutator for arrival date
 * @param arrivalDate passes arrivalDate variable in
 */
    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
/**
 * Accessor for the departure date
 * @return the date of departure
 */
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public double getPrice() {
        return price;
    }

    public double getReviews() {
        return reviews;
    }

    public void setReviews(double reviews) {
        this.reviews = reviews;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
}
