package express;
import java.util.*;

/**
 * Class for bookableEntities for reviews and such for user
 * @author Andrew Garcia, Ryan LeBoeuf
 */
public abstract class BookableEntity {
    protected String name;
    protected UUID uuid = UUID.randomUUID();
    protected double price;
    protected boolean available = true;
    protected ArrayList<Review> reviews;
    public boolean isAFlight = false;

    /**
     * Protected constructor
     * @param uuid
     * @param name
     * @param price
     * @param available
     * @param reviews
     */
    protected BookableEntity(UUID uuid, String name, double price, boolean available, ArrayList<Review> reviews) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
        this.available = available;
        this.reviews = reviews;
    }

    /**
     * Accessor for UUID
     * @return UUID
     */
    public UUID getUUID() {
        return this.uuid;
    }

    /**
     * Reuturns if available 
     * @return availability
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Reuturns if booking is abailable to user
     * @param user user
     * @return if available
     */
    public boolean isAvailableToUser(RegisteredUser user) {
        return available;
    }

    /**
     * Reserve entity
     */
    public void reserve() {
        if (available) {
            this.available = false;
        }
    }

    /**
     * Cancel reservation of entity
     */
    public void cancelReserve() {
        if (!available)  {
            this.available = true;
        }
    }

    /**
     * Adds review to review ArrayList
     * @param firstName first name of review
     * @param rating rating of reivew
     * @param comments comment on reivew
     */
    public void addReview(String firstName, double rating, String comments) {
        Review review = new Review(firstName, rating, comments);
        reviews.add(review);
    }

    /**
     * Getter for name of a bookable entity
     * @return String name of booking
     */
    public String getName() {
        return name;
    }
    /**
     * Gets price of bookable entity
     * @return price of entity
     */
    public double getPrice() {
        return price;
    }
    /**
     * Gets the reviews of the bookable entity
     * @return arraylist of reviews
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }
    
}
