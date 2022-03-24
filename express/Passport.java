/**
 * Class for passport
 * @author Andrew Garcia
 */
package express;
import java.time.LocalDate;
import java.time.format.*;
import java.util.*;

public class Passport {
    private UUID id;
    private String firstName;
    private String lastName;
    private String DOB;
    private String nationality;
    private String POB;
    private Sex sex;
    private String dateIssued;
    private String dateExpiration;
    public static DateTimeFormatter dateFormatter;
    private ArrayList<BookableEntity> destinationHistory = new ArrayList<BookableEntity>();

    /**
     * Constructor for Passport if no UUID is specified
     * @param firstName of the person
     * @param lastName of the person
     * @param DOB of the person
     * @param nationality of the person
     * @param POB of the person
     * @param sex of the person
     * @param dateIssued of the passport
     * @param dateExpiration of the passport
     * @param destinationHistory of the passport/person
     */
    public Passport(String firstName, String lastName, String DOB, String nationality, String POB, 
    String sex, String dateIssued, String dateExpiration, ArrayList<BookableEntity> destinationHistory) {
        this(UUID.randomUUID(), firstName, lastName, DOB, nationality, POB, sex, dateIssued, dateExpiration, destinationHistory);
    }

    /**
 * Contructor for Passport
 * @param id UUID of the passport
 * @param firstName first name of person passport
 * @param lastName last name of person passport
 * @param DOB date of birth of person
 * @param nationality nationality of person
 * @param POB place of birth of person
 * @param sex sex of person
 * @param dateIssued date passport issued
 * @param dateExpiration date passport expired
 * @param destinationHistory destination history on passport
 */
    public Passport(UUID id, String firstName, String lastName, String DOB, String nationality, String POB, 
    String sex, String dateIssued, String dateExpiration, ArrayList<BookableEntity> destinationHistory) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.nationality = nationality;
        this.POB = POB;
        if(sex == "M" || sex == "Male") { this.sex = Sex.MALE; }
        else { this.sex = Sex.FEMALE; }
        this.dateIssued = dateIssued;
        this.dateExpiration = dateExpiration;
        this.destinationHistory = destinationHistory;
    }
/**
 * checks if dateExpiration is valid
 * @return if date is valid
 */
    public boolean isValid() {
        try{
            LocalDate.parse(dateExpiration, this.dateFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
/**
 * return tostring of passport information
 */
    public String toString() {
        return id + " " + firstName + " " + lastName + " " + DOB + " " + DOB + " " + nationality + 
        " " + POB + " " + sex + " " + dateIssued + " " + dateExpiration + " " + destinationHistory;
    }
/**
 * Return uuid of person
 * @return id
 */
    public UUID getId() {
        return id;
    }
/**
 * Return first name of person
 * @return first name
 */
    public String getFirstName() {
        return firstName;
    }
/**
 * Set first name of person
 * @param firstName first name of person
 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
/**
 * Return last name of person
 * @return last name of person
 */
    public String getLastName() {
        return lastName;
    }
/**
 * Sets last name of person
 * @param lastName last name of person
 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
/**
 * Date of birth of person
 * @return date of birth 
 */
    public String getDOB() {
        return DOB;
    }
/**
 * Return nationality of person
 * @return nationality
 */
    public String getNationality() {
        return nationality;
    }
/**
 * Return place of birth of person
 * @return place of birth 
 */
    public String getPOB() {
        return POB;
    }
/**
 * Sex of person
 * @param sex sex of person
 */
    public void setSex(Sex sex) {
        this.sex = sex;
    }
/**
 * Return date passport issued
 * @return date issued
 */
    public String getDateIssued() {
        return dateIssued;
    }
/**
 * Sets date passport issued
 * @param dateIssued date issued
 */
    public void setDateIssued(String dateIssued) {
        this.dateIssued = dateIssued;
    }
/**
 * Return date passport expires
 * @return expiration date
 */
    public String getDateExpiration() {
        return dateExpiration;
    }
/**
 * Set date passport expires
 * @param dateExpiration expiration date
 */
    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
/**
 * Return passport/person destination history 
 * @return
 */
    public ArrayList<String> getDestinationHistory() {
        return destinationHistory;
    }
/**
 * Adds destination to destination history
 * @param destination place person has been
 */
    public void addDestinationHis(String destination) {
        destinationHistory.add(destination);
    }
}
