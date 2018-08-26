package jobhunter;

/**
 * @author douglas
 * Basic data object for location to help with job hunt.
 */

public class Location {

    private static int lastId = 1;

    private int id;
    private String loc;

    public Location(String loc) {
            this.loc = loc;
            this.id = lastId++;
    }
}
