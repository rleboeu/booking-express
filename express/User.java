// package express;

/**
 * a user who has just entered booking express
 * @author Miller Banford
 * @version 1.0.0
 */
public class User {

    protected String location;

    /**
     * constructer
     * @param location String of the location the user is at
     */
    public User(String location) {
        this.location = location;
    }

    /**
     * creates a registered user based on the user's inputted data
     * @param name String
     * @param lastName String
     * @param dob String date of birth
     * @return The RegisteredUser account
     */
    public RegisteredUser createAccoutn(String name, String lastName, int age) {
        return new RegisteredUser(name,lastName, age, location);
    }
    
    /**
     * Accessor for User location
     * @return String location
     */
    public String getLocation() {
        return this.location;
    }

}
