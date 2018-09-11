package jobhunter.data;

import org.w3c.dom.Element;

/**
 * @author douglas
 * Basic data object that stores job title information since the 
 * same job title can exist for more than 1 company
 */

public class JobTitle {

    private static int lastId = 1;
    
    private final String jobTitle;
    private final int id;

    public JobTitle(String title) {
            this.jobTitle = title;
            this.id = lastId++;
    }
    
    @Override
    public String toString() {
        return jobTitle;
    }
    
    public String toXML() {
        return "\t<title>" + jobTitle + "</title>\n";
    }
    
    public static JobTitle getByXMLElement(Element el) {
        if (el == null) return null;
        String name = el.getElementsByTagName("title").item(0).getTextContent();
        return new JobTitle(name);
    }
}
