/**
 * Class for passport
 * @author Andrew Garcia
 */
package express;
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
    private String passportNum;
    private ArrayList<BookableEntity> destinationHistory = new ArrayList<BookableEntity>();
/**
 * Contructor for Passport
 * @param firstName first name of person passport
 * @param lastName last name of person passport
 * @param DOB date of birth of person
 * @param nationality nationality of person
 * @param POB place of birth of person
 * @param sex sex of person
 * @param dateIssued date passport issued
 * @param dateExpiration date passport expired
 * @param passportNum passport number
 * @param destinationHistory destination history on passport
 */
    public Passport(String firstName, String lastName, String DOB, String nationality, String POB, 
    String sex, String dateIssued, String dateExpiration, String passportNum, ArrayList<BookableEntity> destinationHistory) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.nationality = nationality;
        this.POB = POB;
        if(sex == "M" || sex == "Male"){ this.sex = Sex.MALE;}
        else { this.sex = Sex.FEMALE;}
        this.dateIssued = dateIssued;
        this.dateExpiration = dateExpiration;
        this.passportNum = passportNum;
        this.destinationHistory = destinationHistory;
    }
    public boolean isValid() {
        return true;
        //what am i validating?
    }
/**
 * return tostring of passport information
 */
    public String toString() {
        return id + " " + firstName + " " + lastName + " " + DOB + " " + DOB + " " + nationality + 
        " " + POB + " " + sex + " " + dateIssued + " " + dateExpiration + " " + passportNum + " " + destinationHistory;
    }
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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
    public void setDOB(String dOB) {
        DOB = dOB;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getPOB() {
        return POB;
    }
    public void setPOB(String pOB) {
        POB = pOB;
    }
    public Sex getSex() {
        return sex;
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
    public String getPassportNum() {
        return passportNum;
    }
    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }
    public ArrayList<BookableEntity> getDestinationHistory() {
        return destinationHistory;
    }
    public void setDestinationHistory(ArrayList<BookableEntity> destinationHistory) {
        this.destinationHistory = destinationHistory;
    }
}
