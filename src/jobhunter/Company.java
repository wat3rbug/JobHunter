package jobhunter;

/**
 * @author douglas
 * Basic data object for the application.  Store relevant information for 
 * a company.
 */

public class Company {

    private static int lastId = 1;

    private String companyName;
    private Location location;
    private JobTitle title;
    private int id;

    public Company(Location loc, JobTitle title, String name) {
            location = loc;
            this.title = title;
            companyName = name;
            id = lastId++;
    }

    public Company(String name) {
            companyName = name;
            id = lastId++;
    }

    public void SetLocation(Location loc) {
            this.location = loc;
    }

    public void setTitle(JobTitle title) {
            this.title = title;
    }
}
