package jobhunter.data;

import org.w3c.dom.Element;

/**
 * @author douglas
 * Basic data object for location to help with job hunt.
 */

public class Location {

    private static int lastId = 1;

    private final int id;
    public String loc;

    public Location(String loc) {
            this.loc = loc;
            this.id = lastId++;
    }
    
    @Override
    public String toString() {
        return loc;
    }
    
    public static Location getByXMLElement(Element el) {
        if (el == null) return null;
        String name = el.getElementsByTagName("location").item(0).getTextContent();
        return new Location(name);
    }
}
