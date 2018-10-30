package jobhunter.data;

import org.w3c.dom.Element;

/**
 * @author douglas
 * Basic data object that stores job title information since the 
 * same job title can exist for more than 1 company
 */

public class JobTitle {

    private static int lastId = 1;
    
    public String jobTitle;
    private final int id;

    public JobTitle(String title) {
            this.jobTitle = title;
            this.id = lastId++;
    }
    
    /**
     * Overrides the standard toString() method so that display information is
     * given in the job listing panel of the application.
     * @return a String with the job title.
     */
    
    @Override
    public String toString() {
        return jobTitle;
    }
    
    /**
     * Converts an XML Element to a JobTitle object.  This is used for reading an
     * XML file to get all the relevant details for the JobTitle object.
     * @param el
     * @return a JobTitle object with all the details of the job title.
     */
    
    public static JobTitle getByXMLElement(Element el) {
        if (el == null) return null;
        String name = el.getElementsByTagName("title").item(0).getTextContent();
        return new JobTitle(name);
    }
}
