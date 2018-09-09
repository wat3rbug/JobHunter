package jobhunter;

/**
 * @author douglas
 * Basic data object for location to help with job hunt.
 */

public class Location {

    private static int lastId = 1;

    private final int id;
    private final String loc;

    public Location(String loc) {
            this.loc = loc;
            this.id = lastId++;
    }
    
    @Override
    public String toString() {
        return loc;
    }
}
