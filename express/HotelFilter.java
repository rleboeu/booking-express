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
    private int cheese;

    public HotelFilter(){
        arrivalDate = LocalDate.of(2022, 03, 17);
        departureDate = LocalDate.of(2022, 03, 17);
        departureDate = LocalDate.now();
        price = 0.0;
        reviews = 0.0;
        location = "No Location";
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }
    
}
