/**
 * Class for passport
 * @author Andrew Garcia
 */
package express;
import java.util.*;

public class Passport {
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

    public Passport(String firstName, String lastName, String DOB, String nationality, String POB, 
    Sex sex, String dateIssued, String dateExpiration, int passportNum, ArrayList<String> destinationHistory) {
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
