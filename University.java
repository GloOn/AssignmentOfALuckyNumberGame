import java.util.*;
import java.io.*;

/**
 * This class keeps and defines the following information:
 * (1) student object list created
 * (2) unit object list created
 * (3) course type definition which will be used when create a student object
 * (4) campus type definition which will be used when create a student object
 */
public class University implements Serializable {

	// students created. The first parameter is a student id, and second parameter is student object.
	// Throught the student id field, we can easily get a student object from the students.
	private Map<String, Student> studentList;

	// units created. The first parameter is a unit code, and second parameter is unit object.
	// Throught the code, we can easily get a unit object from the units.
	private Map<String, Unit> unitList;

	public enum CourseType {
		Undergraduate, Postgraduate;
	}

	public enum CampusType {
		Clayton, Caulfield, Berwick, Gippsland, SouthAfrica, Malaysia;
	}

	/**
	 * Constructor
	 * Creates empty lists of students and units.
	 */
	public University() {
		studentList = new HashMap<String, Student>();
		unitList = new HashMap<String, Unit>();
	}

	/**
	 * Add a new unit into units
	 * @param unit a unit object
	 */
	public void addUnit(Unit unit) {
		unitList.put(unit.getCode(), unit);
	}

	/**
	 * Add a new unit into students
	 * @param student a student object
	 */
	public void addStudent(Student student) {
		studentList.put(student.getId(), student);
	}

	/**
	 * Returns all student objects created in university
	 * @return student objects
	 */
	public Collection<Student> getAllStudents()	{
		return studentList.values();
	}

	/**
	 * Displays all student information (id, name, campus)
	 */
	public void displayAllStudents() {
		StringBuilder output = new StringBuilder();
		for (Student student : studentList.values()) {
			output.append(student.toString());
		}
		System.out.println(output.toString());
	}

	/**
	 * Returns all student objects enrolled in the given unit.
	 * @param unit a unit object
	 * @return student object list enrolled in the unit.
	 */
	public Collection<Student> getAllStudentsInUnit(Unit unit) {
		return unit.getAllStudents();
	}

	/**
	 * Returns all unit objects created in the university
	 * @return unit objects
	 */
	public Collection<Unit> displayAllUnits() {
		return unitList.values();
	}

	/**
	 * Search for a student object with the given student id
	 * @param aStudentId a student id to be searched
	 * @return a student object matched with the input student id
	 */
	public Student searchStudent(String aStudentId) {
		return studentList.get(aStudentId);
	}

	/**
	 * Search for a unit object with the given unit code
	 * @param aUnitCode a unit code to be searched
	 * @return a unit object matched with the input unit id
	 */
	public Unit searchUnit(String aUnitCode) {
		return unitList.get(aUnitCode);
	}

	/**
	 * Creates a new student and add it to the student list (i.e. studentList) in the university
	 * @param name student name
	 * @param campus campus to be added to the student
	 */
	public void createStudent(String name, String campus) {
		Student student = new Student (name, campus);
		addStudent(student); // add a new student to the student list kept in the university
	}

	/**
	 * Create a new unit and add it to the unit list (i.e. unitList) in the university
	 * @param code unit code
	 * @param title unit title
	 */
	public void createUnit(String code, String title) {
		Unit unit = new Unit(code, title);
		addUnit(unit); // add a new unit to the unit list kept in the university
	}

	/**
	 * Modify the name of given unit
 	 * @param unit the unit object to be modified
	 * @param aName the new unit title
	 */
	public void modifyUnitName(Unit unit, String aName) {
		unit.setTitle(aName);
	}

	/**
	 * Deleate a unit:
	 * (1) Check whether there is any student enrolled in the given unit
	 * (2) If none, delete it.
	 * @param unit
	 */
	public void deleteUnit(Unit unit) {
		if (unit.getAllStudents().isEmpty()) {
			unitList.remove(unit.getCode());
		} else {
			System.out.println("This unit cannot be deleted as it has enrolled students.");
		}
	}

	/**
	 * Check whether the given student id exists!
	 * @param studId a student id
	 * @return if exists return true, otherwise, return false
	 */
	public boolean validateStudentId (String studId) {
		if (studentList.containsKey(studId))
			return true;
		else
			return false;
	}
}