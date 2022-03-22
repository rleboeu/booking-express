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
    private ArrayList<String> destinationHistory = new ArrayList<String>();

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
    Sex sex, String dateIssued, String dateExpiration, ArrayList<String> destinationHistory) {
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
    Sex sex, String dateIssued, String dateExpiration, ArrayList<String> destinationHistory) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.nationality = nationality;
        this.POB = POB;
        this.sex = sex;
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
   
    public UUID getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getDOB() {
        return DOB;
    }
    public String getNationality() {
        return nationality;
    }
    public String getPOB() {
        return POB;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public String getDateIssued() {
        return dateIssued;
    }
    public void setDateIssued(String dateIssued) {
        this.dateIssued = dateIssued;
    }
    public String getDateExpiration() {
        return dateExpiration;
    }
    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
    public ArrayList<String> getDestinationHistory() {
        return destinationHistory;
    }
    public void addDestinationHis(String destination) {
        destinationHistory.add(destination);
    }
}
