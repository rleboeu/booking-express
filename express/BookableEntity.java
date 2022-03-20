/**
 * Class for bookableEntities for reviews and such for user
 * @author Andrew Garcia
 */
package express;
import java.util.*;

public abstract class BookableEntity {
    protected String name;
    protected UUID uuid = UUID.randomUUID();
    protected double price;
    protected boolean available;
    protected ArrayList<Review> reviews = new ArrayList<Review>();
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
 * Reserve entity for user
 * @param user user 
 */
    public void reserve(RegisteredUser user) {
        
    }

    public void cancelReserve(RegisteredUser user) {
        
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
}
