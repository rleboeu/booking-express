/**
 * Class for bookableEntities for reviews and such for user
 * @author Andrew Garcia
 */
package express;
import java.util.*;

public abstract class BookableEntity {
    protected String name;
    protected UUID uuid;
    protected double price;
    protected boolean available;
    protected ArrayList<Review> reviews = new ArrayList<Review>();

    public boolean isAvailable() {

        return available;
    }
    public boolean isAvailableToUser(RegisteredUser user) {

        return available;
    }
    public void reserve(RegisteredUser user) {
        
    }
    public void addReview(String firstName, double rating, String comments) {
        Review review = new Review(firstName, rating, comments);
        reviews.add(review);
    }
}
