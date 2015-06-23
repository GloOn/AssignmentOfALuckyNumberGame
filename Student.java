import java.io.Serializable;
import java.util.*;

/**
 * This class represents a student object consisting of id, name, and campusName where a student is enrolled.
 */
public class Student implements Serializable {
	private String id; // student id
    private String name; // student name
    private String campusName; // campus name enrolled

    /**
     * This is a constructor that creates a Student object and initializes values by passing the parameters
     * Note that a studdent is automatcally given by the system when creating a student. This is done by createId() method.
     * @param name The given student name
     */
    public Student(String name, String campusName) {
    	this.name = name;
    	this.id = createId(); // automatically creates a student id (8-digits)
        this.campusName = campusName;
    }

    /**
     * Student Id number is an 8 digit unique identity code for each student containing
     * a check digit. A check digit is the 8th digit, which is the sum of the first 7
     * digits divided by 10.
     * @return the 8-digit student id
     */
    public String createId() {

        String Digit = "0123456789";
        Random random = new Random();

        String id = "";
        int nId = 0;
        for(int i = 0; i < 9; i++) {
            char digit = Digit.charAt(random.nextInt(Digit.length()));
            id += String.valueOf(digit);
            nId += digit;
        }
        return id + String.valueOf(nId%10);
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getCampus() {
        return campusName;
    }

    public void setCampus(String campusName) {
        this.campusName = campusName;
    }

    public String toString() {
    	return("\n\tName: " + this.name +
                "\n\tID: " + this.id +
                "\n\tCampus: " + campusName);
    }
}