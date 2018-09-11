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

    private String companyName;
    private boolean isStaffing;
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
    
    @Override
    public String toString() {
        if (isStaffing == true) return companyName + ", staffing";
        else return companyName;
        
        // this should easily be written as but its not working with is IDE
        // return companyName + (isStaffing ? ", staffing" : " ");
    }
    public String toXML() {
        String message = "\t<company>\n\t\t<name>" + companyName + "</name>\n" +
                "\t\t<staffing>" + StringExtender.toYesNoString(isStaffing) +
                "</staffing>\n\t</company>\n";
        return message;
    }
    
    public static Company getByXMLElement(Element el) {
        if (el == null) return null;
        String name = el.getElementsByTagName("name").item(0).getTextContent();
        String staffingStr = el.getElementsByTagName("staffing").item(0)
                .getTextContent();
        return new Company(name, staffingStr);
    }
}
