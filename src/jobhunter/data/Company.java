package jobhunter.data;

import jobhunter.StringExtender;
import org.w3c.dom.Element;

/**
 * @author douglas
 * Basic data object for the application.  Store relevant information for 
 * a company.
 */

public class Company {

    private static int lastId = 1;

    public String companyName;
    public boolean isStaffing;
    private int id;

    public Company(String name) {
            companyName = name;
            isStaffing = false;
            id = lastId++;
    }
    
    public Company(String name, String isStaffing) {
        this(name);
        this.isStaffing = StringExtender.toBooleanValue(isStaffing);     
    }
    
    /**
     * Overrides the standard toString() method so that display information is
     * given in the job listing panel of the application.
     * @return a String with the company name and staffing if it applies.
     */
    
    @Override
    public String toString() {
        if (isStaffing == true) return companyName + ", staffing";
        else return companyName;
    }
    
    /**
     * Converts an XML Element to a Company object.  This is used for reading an
     * XML file to get all the relevant details for the Company object.
     * @param el
     * @return a Company object with all the details of the company
     */
    
    public static Company getByXMLElement(Element el) {
        if (el == null) return null;
        String name = el.getElementsByTagName("name").item(0).getTextContent();
        String staffingStr = el.getElementsByTagName("staffing").item(0)
                .getTextContent();
        return new Company(name, staffingStr);
    }
}
