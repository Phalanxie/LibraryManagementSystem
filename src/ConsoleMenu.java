import java.util.Scanner;
/**
 * Robert Ruiz
 * CEN 3024 - Software Development 1
 * January 25, 2025
 * LibraryManagementSystem.java
 * This  class creates a menu object that will be used in Main.Java to handle all menu choices.
 */
public class ConsoleMenu
{
    LibraryManagementSystem LMS = new LibraryManagementSystem();
    Scanner scanner = new Scanner(System.in);

    /**
     * method: DisplayMenu
     * parameters: none
     * return: none
     * purpose: displays a menu to the end-user (library employee) for main application
     * functions (add, remove, show patrons)
     */
    void DisplayMenu()
    {
        int choice = 0;
        do {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. Add user (from file)");
            System.out.println("2. Add user");
            System.out.println("3. Remove user");
            System.out.println("4. Show all users");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");
            choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    String filename;
                    System.out.print("Enter filename (full path with '.txt'): ");
                    filename = scanner.next();
                    LMS.AddPatronFromFile(filename);
                    break;

                case 2:
                    LMS.AddPatronManually();
                    break;

                case 3:
                    LMS.RemovePatronByID();
                    break;

                case 4:
                    LMS.DisplayAllPatrons();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }while (choice != 5);

    }
}
