import java.lang.Character;
import java.util.regex.Pattern;

/**
 * This class contains different validation functions.
 */

public class Validation {
	private AdministratorMenu menu;
	private Character ch;
	private Pattern pattern;

	/**
	 * Create a new instance of AdministratorMenu.
	 */
	public Validation() {
		menu = new AdministratorMenu();
	}

	/**
	 * Check whether the student status is A, C, or D. If the status doesn't belong to one of those status, return false,
	 * otherwise, return true.
	 * @param status student status
	 * @return if the status is valid, return true, and otherwise, return false.
	 */
	public boolean validateStudentCourseStatus(String status) {

		boolean result = true;
		// A: active, C: completed, D: dropped
		if(status.equalsIgnoreCase("A") || status.equalsIgnoreCase("C") || status.equalsIgnoreCase("D")) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * Check whether the unit code has a valid form or not. If valid, return true, and otherwise, return false.
	 * @param unitCode unit code
	 * @return if the code is valid, return true, and otherwise, return false.
	 */
	public boolean validateUnitCode(String unitCode) {

		// Check weather the length of the unit code is 7.
		if (unitCode.length() == 7) {

			// Check whether the first 3 characters of the code are letters
			for (int i=0; i<3; i++) {
				if (!Character.isUpperCase(unitCode.charAt(i))) return false;
			}

			// Check whether the last 4 characters of the code are digits
			for (int i=3; i<7; i++) {
				if (!Character.isDigit(unitCode.charAt(i))) return false;
			}
		} else {
			return false;
		}
		return true;
	}

	/**
	 * Check whether the course code has a valid form or not. If valid, return true, and otherwise, return false.
	 * @param courseCode course code
	 * @return if the code is valid, return true, and otherwise, return false.
	 */
	public boolean validateCourseCode(String courseCode) {

		// Check weather the length of the course code is 4 and the code consists of digits.
		if (courseCode.length() == 4) {
			for (int i=0; i<4; i++) {
				if (!Character.isDigit(courseCode.charAt(i))) return false;
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check whether the course type is Undergraduate or Postgraduate.
	 * @param courseType course code
	 * @return if the course type's index is in [0,1], return true. Otherwise return false.
	 */
	public boolean validateCourseType(int courseType) {
		if (courseType >= 0 && courseType <= University.CourseType.values().length) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check whether the campus type is Clayton, Caulfield, Berwick, Gippsland, SouthAfrica, or Malaysia.
	 * @param campusType campus code
	 * @return if the campus type's index is in [0,5], return true. Otherwise return false.
	 */
	public boolean validateCampus(int campusType) {
		if (campusType >= 0 && campusType <= University.CampusType.values().length) {
			return true;
		} else {
			return false;
		}
	}
}