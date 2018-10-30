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
    
    /**
     * Overrides the standard toString() method so that display information is
     * given in the job listing panel of the application.
     * @return a String with the location.
     */
    
    @Override
    public String toString() {
        return loc;
    }
    
    /**
     * Converts an XML Element to a Location object.  This is used for reading 
     * an XML file to get all the relevant details for the Location object.
     * @param el
     * @return a Location object with all the details of the location.
     */
    
    public static Location getByXMLElement(Element el) {
        if (el == null) return null;
        String name = el.getElementsByTagName("location").item(0).getTextContent();
        return new Location(name);
    }
}
