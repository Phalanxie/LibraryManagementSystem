/**
 * Robert Ruiz
 * CEN 3024C - Software Development 1
 * January 25, 2025
 * Main.java
 * This application will allow librarians to add (via file or manually), remove,
 * and show patrons of the library system.
 */
public class Main
{
    public static void main(String[] args)
    {
        ConsoleMenu menu = new ConsoleMenu();
        menu.DisplayMenu();
    }
}