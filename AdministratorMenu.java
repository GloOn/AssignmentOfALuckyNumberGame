/**
 * @(#)AdministratorMenu.java
 *
 *
 * @author 
 * @version 1.00 2010/5/24
 */

import java.io.Serializable;
import java.util.Scanner;

/**
 * This class is an interface of the SES I system. It prompts requests based on a command selected by the administrator
 * and takes inputs from the administrator.
 */
public class AdministratorMenu implements Serializable {

    private Scanner scanner = new Scanner(System.in);
    public AdministratorMenu() {
        scanner = new Scanner(System.in);
    }
    
    public CourseAdmin.Command promptMainMenu() {
        return getCommand("\nPlease select from the following options:" +
                "\n[1] Create a new student" +
                "\n[2] Enroll a student to a unit" +
                "\n[3] Search a new student" +
                "\n[4] Display students in a unit" +
                "\n[5] Display students" +

                "\n[6] Create a new unit" +
                "\n[7] Modify unit name" +
                "\n[8] Delete unit" +
                "\n[9] Display all units" +

                "\n[0] exit" +
                "\nYou choose: ");
    }

    /**
     * Returns the selected menu number by the administrator
     * @param text show text to the administrator and prompt a menu number
     * @return a menu number
     */
    protected CourseAdmin.Command getCommand(String text) {
        System.out.print(text);
        int input = scanner.nextInt();
        scanner.nextLine();
        return CourseAdmin.Command.values()[input];
    }

    /**
     * This function will get a string value from the administrator
     * @param text the text to be shown to the administrator
     * @return the input string received from the administrator
     */
    protected String getString(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }

    /**
     * This function will get an int value from the administrator
     * @param text the text to be shown to the administrator
     * @return the input int value received from the administrator
     */
    protected int getInt(String text) {
        System.out.print(text);
        return Integer.parseInt(scanner.nextLine());
    }
}