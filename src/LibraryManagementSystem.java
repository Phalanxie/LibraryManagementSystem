import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Robert Ruiz
 * CEN 3024 - Software Development 1
 * January 25, 2025
 * LibraryManagementSystem.java
 * This class creates an LMS object to handle all patron object storage, creation, deletion, and displaying
 * */

public class LibraryManagementSystem
{
    Scanner scanner = new Scanner(System.in);
    List<Patron> users = new ArrayList<>();
    String separator = "-";

    //patron info variables to ask user for patron info
    private int patron_ID;
    private String patron_Name, patron_address;
    private float patron_overdue_fine;

    /**
     * method: AddPatronFromFile
     * parameters: String
     * return: none
     * purpose: creation of patron object from text file
     */
    void AddPatronFromFile(String fileName)
    {
        try {
            // regular expression: Split the input line into a string array by the separator (hyphen), limited to 4 entries for inputs
            Files.lines(Paths.get(fileName)).forEach(line -> {
                String[] tokens = line.split(separator,4);
                patron_ID = Integer.parseInt(tokens[0].trim());
                if (String.valueOf(patron_ID).length() != 7)
                {
                    System.out.println("Invalid ID. Please enter a valid Patron ID (must be 7 digits)");
                    return;
                }
                patron_Name = tokens[1].trim();
                patron_address = tokens[2].trim();
                patron_overdue_fine = Float.parseFloat(tokens[3].trim());

                Patron user = new Patron(patron_ID, patron_Name, patron_address, patron_overdue_fine);
                users.add(user);

                System.out.println("Patron Added Successfully\n\n");

                DisplayAllPatrons();

            });
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * method: AddPatronManually
     * parameters: none
     * return: none
     * purpose: creation of patron object from manual data entry
     */
    void AddPatronManually()
    {
        System.out.println("enter ID,name,address, and fines separated by a hyphen: ");
        String input = scanner.nextLine();
        String[] tokens =  input.split(separator, 4);

        patron_ID = Integer.parseInt(tokens[0].trim());
        if (String.valueOf(patron_ID).length() != 7)
        {
            System.out.println("Invalid ID. Please enter a valid Patron ID (must be 7 digits)");
            return;
        }

        patron_Name = tokens[1].trim();
        patron_address = tokens[2].trim();
        patron_overdue_fine = Float.parseFloat(tokens[3].trim());
        Patron user = new Patron(patron_ID, patron_Name, patron_address, patron_overdue_fine);
        users.add(user);

        System.out.println("Patron Added Successfully\n\n");
        DisplayAllPatrons();
    }

    /**
     * method: RemovePatronByID
     * parameters: none
     * return: none
     * purpose: remove patron object by patron_ID
     */
    void RemovePatronByID()
    {
        System.out.println("Enter patron ID: ");
        int patron_ID = scanner.nextInt();
        for (int i = 0; i < users.size(); i++)
        {
            if(patron_ID == users.get(i).patron_ID)
            {
                if (users.get(i).patron_overdue_fine > 0)
                {
                    System.out.println("Patron has not paid overdue fines, cannot remove user.");
                    return;
                }
                else
                {
                    users.remove(i);
                    System.out.println("Patron Removed Successfully\n\n");
                    DisplayAllPatrons();
                    return;
                }
            }
        }
        System.out.println("Patron ID: " + patron_ID + " does not exist. Returning to menu...");
        DisplayAllPatrons();
    }

    /**
     * method: DisplayAllPatrons
     * parameters: none
     * return: none
     * purpose: display all patrons in patron ArrayList
     */
    void DisplayAllPatrons()
    {
        System.out.println("\nPrinting all Patron data....\n");
        for (Patron patron : users)
        {
            String print = patron.toString();
            System.out.println(print);
        }
    }

    public LibraryManagementSystem(){}

    public int getPatron_ID() {
        return patron_ID;
    }

    public void setPatron_ID(int patron_ID) {
        this.patron_ID = patron_ID;
    }

    public String getPatron_Name() {
        return patron_Name;
    }

    public void setPatron_Name(String patron_Name) {
        this.patron_Name = patron_Name;
    }

    public String getPatron_address() {
        return patron_address;
    }

    public void setPatron_address(String patron_address) {
        this.patron_address = patron_address;
    }

    public float getPatron_overdue_fine() {
        return patron_overdue_fine;
    }

    public void setPatron_overdue_fine(float patron_overdue_fine) {
        this.patron_overdue_fine = patron_overdue_fine;
    }
}


