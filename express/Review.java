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
    
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
}
