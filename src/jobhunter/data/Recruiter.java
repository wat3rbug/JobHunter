package jobhunter.data;

import org.w3c.dom.Element;

/**
 * @author Douglas Gardiner
 * Basic data object for recruiter to help with job hunt.
 */
public class Recruiter {

    private static int lastId = 1;

    private final int id;
    public String recruiter;
    
    public Recruiter(String recruiter) {
            this.recruiter = recruiter;
            this.id = lastId++;
    }
    
    /**
     * Overrides the standard toString() method so that display information is
     * given in the job listing panel of the application.
     * @return a String with the location.
     */
    
    @Override
    public String toString() {
        return recruiter;
    }
    
    /**
     * Converts an XML Element to a Recruiter object.  This is used for reading 
     * an XML file to get all the relevant details for the Recruiter object.
     * @param el
     * @return a Location object with all the details of the recruiter.
     */
    
    public static Recruiter getByXMLElement(Element el) {
        if (el == null) return null;
        String name = null;
        try {
            name = el.getElementsByTagName("recruiter").item(0).getTextContent();
        } catch (Exception e) {
            return null;
        }
        return new Recruiter(name);
    }
}
