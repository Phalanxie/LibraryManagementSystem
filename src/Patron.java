/**
 * Robert Ruiz
 * CEN 3024 - Software Development 1
 * January 25, 2025
 * Patron.java
 * This class creates a patron object to handle individual patron object data inputted by end-user
 */
public class Patron
{
    int patron_ID;
    String patron_Name;
    String patron_address;
    float patron_overdue_fine;

    public Patron(int patron_ID, String patron_Name, String patron_address, float patron_overdue_fine)
    {
        this.patron_ID = patron_ID;
        this.patron_Name = patron_Name;
        this.patron_address = patron_address;
        this.patron_overdue_fine = patron_overdue_fine;
    }

    @Override
    public String toString()
    {
        return "Patron: " +
                "patron ID=" + patron_ID +
                ", Name='" + patron_Name + '\'' +
                ", address='" + patron_address + '\'' +
                ", overdue_fine=" + patron_overdue_fine +
                '\n';
    }


}
