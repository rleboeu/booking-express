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
    private int passportNum;
    private ArrayList<String> destinationHistory = new ArrayList<String>();
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
    Sex sex, String dateIssued, String dateExpiration, int passportNum, ArrayList<String> destinationHistory) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.nationality = nationality;
        this.POB = POB;
        this.sex = sex;
        this.dateIssued = dateIssued;
        this.dateExpiration = dateExpiration;
        this.passportNum = passportNum;
        this.destinationHistory = destinationHistory;
    }
}
