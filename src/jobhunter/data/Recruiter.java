package jobhunter.data;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * @author Douglas Gardiner
 */
public class Recruiter {

    private static int lastId = 1;

    private final int id;
    public String recruiter;
    
    public Recruiter(String recruiter) {
            this.recruiter = recruiter;
            this.id = lastId++;
    }
    
    @Override
    public String toString() {
        return recruiter;
    }
    
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
