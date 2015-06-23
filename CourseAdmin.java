import java.io.*;
import java.util.*;

/**
 * This class is the controller of the SES I system. When it creates, it creates a univeristy object and menu object and validation object.
 * The university object will contain all information of students and units created by the administrator.
 * The menu object (AdministratorMenu) will interface between the administrator and the system
 * The validation object will take the responsibility of checking all different inputs and existence of a given student id or unit id
 */

public class CourseAdmin {

	private University university; // the university object
	private AdministratorMenu menu; // the menu object
	private Validation valid; // validation object

	// Different menus are defined in enumeration
	public enum Command {
		Exit,
		CreateStudent, EnrollStudent, SearchStudent, DisplayStudentsInUnit, DisplayStudents,
		CreateUnit, ModifyUnit, DeleteUnit, DisplayAllUnit;
		public static final Command values[] = values();
	};

	/**
	 * Constructor: creates a university, menu, and valiation object
	 */
	public CourseAdmin() {
		university = new University();
		menu = new AdministratorMenu();
		valid = new Validation();
	}

	/**
	 * Create a student by communicating with the administrator.
	 * Prompt student name and campus, then create a student and add it into the university.
	 */
	public void createStudent() {

		boolean tag = false;

		// A question that will be given to the adminstrator
		String name = menu.getString("\nEnter student's name: ");

		tag = false;
		University.CampusType campusType = null;

		// Until campus input is valid, iteratively prompt a question to the adminstrator
		while(!tag) {
			int input = menu.getInt("Choose Campus: " + getCampusOption());
			tag = valid.validateCampus(input);
			campusType = University.CampusType.values()[input];
		}

		// Create a student and add it to the student list in the university
		university.createStudent(name, campusType.name());

		// Display a successful message
		System.out.println("Student created.");
	}

	/**
	 * Create a unit by communicating with the administrator.
	 * Prompt unit code and title (name), then create a unit and add it into the university.
	 */
	public void createUnit() {
		boolean tag = false;

		// A question that will be given to the adminstrator
		// Until unit code is valid, iteratively prompt a question to the adminstrator
		String code = "";
		while(!tag) {
			code = menu.getString("Enter unit code: ");
			tag = valid.validateUnitCode(code);
		}

		// Ask a unit title
		String name = menu.getString("Enter unit's name: ");

		// Create a unit and add it to the unit list in the university
		university.createUnit(code, name);

		// Display a successful message
		System.out.println("Unit created.");
	}

	/**
	 * Return the campus information aggregated with the comma (,). The campus information is predefined in
	 * the university object as a enumeration. The returned campus information will be used when creating a student.
	 * @return campus information aggregated with the comma.
	 */
	private String getCampusOption() {
		int index = 0;
		StringBuilder output = new StringBuilder();
		for (University.CampusType id: University.CampusType.values()) {
			output.append(index++ + "='" + id.name() + "', ");
		}
		return output.toString();
	}

	/**
	 * Enroll a student into a unit.
	 */
	public void enrollStudent() {

		// Ask a student id to be enrolled.
		String studId = "";
		studId = menu.getString("\nEnter student Id: ");

		// Check whether the input id is valid or not. If not, the enrollment is not possible
		if (!university.validateStudentId(studId)) {
			System.out.println("The input student id does not exist!");
			return;
		}

		// Get the student object from the university
		Student student = university.searchStudent(studId);

		// Get all units created in the university and shows them to the administrator.
		int unitSize = university.displayAllUnits().size();
		System.out.println("Available units are:\n");
		System.out.println(university.displayAllUnits() + "\n");

		if (unitSize == 0) {

			// If no unit is available, then show the following message.
			System.out.println("You should create units first!");
		} else {

			// If there are units created already, then prompt a unit code to the administrator.
			// Unitil the unput unit code is valid, iteratively prompt a unit code.
			String unitCode = "";
			boolean tag = false;
			while (!tag) {
				unitCode = menu.getString("Enter unit code: ");
				tag = valid.validateUnitCode(unitCode);
			}

			// If a valid unit code is given from the administrator, get the unit object from the university,
			// and enroll the student into the unit object.
			Unit unit = university.searchUnit(unitCode);
			unit.addStudent(student);

			// Update the unit information and student information
			university.addUnit(unit);
			university.addStudent(student);

			// Display a successful message
			System.out.println("Enrolled successfully!");
		}
	}

	/**
	 * Modify the title of a given unit code
	 */
	public void modifyUnitName() {
		boolean tag = false;

		// Until a unit code is valid, iteratively prompt a question to the administrator
		String unitCode = "";
		while(!tag) {
			unitCode = menu.getString("\nEnter unit code: ");
			tag = valid.validateUnitCode(unitCode);
		}

		// If a unit code is valid, the prompt the new title of the unit
		String newTitle = menu.getString("Enter new title: ");

		// Get the unit object from the univeristy and change its title
		Unit unit = university.searchUnit(unitCode);
		if (unit != null) {
			unit.setTitle(newTitle);
			System.out.println("Modification Success.");
		} else {
			System.out.println("There is no unit matched with the given unit code!");
		}
	}

	/**
	 * Deleate a unit
	 */
	public void deleteUnit() {
		boolean check = false;

		// Until a unit code is valid, iteratively prompt a question to the administrator
		String code = "";
		while(!check) {
			code = menu.getString("\nEnter unit code: ");
			check = valid.validateUnitCode(code);
		}

		// If a unit code is valid, delete the unit
		university.deleteUnit(university.searchUnit(code));
	}

	/**
	 * Display the input collection of objects. The input collection indicates unit list or student list
	 */
	public void display(Collection collection) {
		StringBuilder output = new StringBuilder();
		if (collection.size() > 0) {
			for (Object object:collection) {
				output.append(object.toString());
			}
		} else {
			output.append("Nothing found.");
		}
		System.out.println(output.toString());
	}

	/**
	 * Display all units in the university
	 */
	public void displayAllUnits() {
		display(university.displayAllUnits());
	}

	/**
	 * Display all students enrolled in the input unit code
	 */
	public void displayStudentsInUnit() {
		boolean tag = false;

		// Until a unit code is valid, iteratively prompt a question to the administrator
		String code = "";
		while(!tag) {
			code = menu.getString("\nEnter unit code: ");
			tag = valid.validateUnitCode(code);
		}

		// If a unit code is valid, show all students enrolled in the unit
		display(university.searchUnit(code).getAllStudents());
	}

	/**
	 * Search for a student with a given student id from the university
	 */
	public void searchStudent() {

		String id = menu.getString("\nEnter student Id: ");
		System.out.println(university.searchStudent(id).toString());
	}

	/**
	 * This method will be called first in the SES I system. It shows menus availalble in the system, and responses accordingly.
	 * Depending on a given menu, it will call an appropriate method defined in this class.
	 */
	public void run() {

		Command command;

		// Unitil the command given from the administrator is "exit", perform the following iteratively.
		do {

			// Show menus and receive a command from the administrator
			command = menu.promptMainMenu();

			// Based on the command, call the appropriate method
			switch (command) {

				/**
				 * Menus for students
				 */
				case CreateStudent:
					createStudent();
					break;
				case EnrollStudent:
					enrollStudent();
					break;
				case SearchStudent:
					searchStudent();
					break;
				case DisplayStudentsInUnit:
					displayStudentsInUnit();
					break;
				case DisplayStudents:
					university.displayAllStudents();
					break;

				/**
				 * Menus for unit
				 */
				case CreateUnit:
					createUnit();
					break;
				case ModifyUnit:
					modifyUnitName();
					break;
				case DeleteUnit:
					deleteUnit();
					break;
				case DisplayAllUnit:
					displayAllUnits();
					break;

			}

		} while (command != Command.Exit);
		exit();
	}

	/**
	 * Exit the program
	 */
	private void exit() {
		System.out.println("Exit.");
		System.exit(0);
	}

	/**
	 * The main function of the SES I system
	 */
	public static void main(String[] args) {
		CourseAdmin admin = new CourseAdmin();
		admin.run();
	}

}