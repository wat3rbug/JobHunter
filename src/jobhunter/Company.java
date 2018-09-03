package jobhunter;

/**
 * @author douglas
 * Basic data object for the application.  Store relevant information for 
 * a company.
 */

public class Company {

    private static int lastId = 1;

    private String companyName;
    private int id;

    public Company(String name) {
            companyName = name;
            id = lastId++;
    }
}
