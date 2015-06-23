
import java.io.Serializable;
import java.util.*;

/**
 * This class represents the unit information. It cosists of three different information kinds:
 * (1) unit code,
 * (2) unit title
 * (3) students enrolled in the unit. The student information is reprsented using two parts: (a) student id, (2) student object
 */
public class Unit implements Serializable {
    private String code; // unit code, three capital letters followed by 4 digits
	private String title; // unit title

    // students enrolled in the unit. The first parameter is a student id, and second parameter is student object.
    // Throught the student id field, we can easily get a student object from the students.
	private Map<String, Student> students;

    /**
     * Default constructor
     */
    public Unit() {
        this.code = "";
    	this.title = "";
    	this.students = new HashMap<String, Student>(); // create an empty student list.
    }
    
    /**
     * This is a constructor that creates a Unit object and initializes values by passing the parameters
     */
    public Unit(String code, String title) {
    	this.code = code;
        this.title = title;
        this.students = new HashMap<String, Student>(); // create an empty student list.
    }
    
    /**
     * This method returns all student objects enrolled in the unit.
     * @return
     */
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Add a new student into "students".
     * @param aStudent
     */
    public void addStudent(Student aStudent) {
        students.put(aStudent.getId(), aStudent);
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String toString() {
    	return("\n\tUnit Code: " + this.code + "\n\tUnit Title: " + this.title);
    }
}