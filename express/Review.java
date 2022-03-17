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
}
