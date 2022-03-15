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
    protected ArrayList<Review> reviews;

    public boolean isAvailable() {
        return true;
    }
    public boolean isAvailableToUser(RegisteredUser user) {

    }
    public void reserve(ReigisteresUser user) {

    }
    public void addReview(String firstName, double rating, String comments) {

    }
}
