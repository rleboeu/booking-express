/**
 * Class for reviews on bookableEntities
 * @author Andrew Garcia
 */
package express;

public class Review {
    private double rating;
    private String firstName;
    private String comments;
/**
 * Contructor for writing a review
 * @param firstname String for first name of person writing review
 * @param rating rating of review
 * @param comments coment on review
 */
    public Review(String firstName, double rating, String comments) {
        this.rating = rating;
        this.firstName = firstName;
        this.comments = comments;
    }
/**
 * returns toString of rating contents
 */
    public String toString() {
        return rating + " " + firstName + " " + comments;
    }
/**
 * Returns rating
 * @return rating of review
 */
    public double getRating() {
        return rating;
    }
/**
 * Sets rating
 * @param rating rating of review
 */
    public void setRating(double rating) {
        this.rating = rating;
    }
/**
 * Returns first name of review writer
 * @return first name
 */
    public String getFirstName() {
        return firstName;
    }
/**
 * Set first name
 * @param firstName first name
 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
/**
 * Get comment on review
 * @return comment on review
 */
    public String getComments() {
        return comments;
    }
/**
 * Set comment of review
 * @param comments comment on review
 */
    public void setComments(String comments) {
        this.comments = comments;
    }
}
