package jobhunter.data;

import java.text.SimpleDateFormat;
import jobhunter.data.Company;
import java.util.Date;
import jobhunter.StringExtender;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Basic data class for the application
 * @author Douglas Gardiner
 */
public class Job {

    public JobTitle title;
    public Location loc;
    public Company company;
    public Date date;
    public boolean hadInterview;
    
    public String toXML() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String message = "<Job>\n\t<date>" + formatter.format(date) +
                "</date>\n\t<interview>" + title.toXML() + StringExtender
                        .toYesNoString(hadInterview) + "</interview>\n" +
                loc.toXML() + company.toXML() + "</Job>";
        return message;
    }
    
    public static Job getByXMLElement(Element el) {
        if (el == null) return null;
        Job job = new Job();
        String dateStr = el.getElementsByTagName("date").item(0).getTextContent();
        Date tempDate = new Date(dateStr);
        job.date = tempDate;
        String intStr = el.getElementsByTagName("interview").item(0)
                .getTextContent();
        boolean interview = StringExtender.toBooleanValue(intStr);
        job.hadInterview = interview;
        job.loc = new Location(el.getElementsByTagName("location").item(0)
                .getTextContent());
        job.title = new JobTitle(el.getElementsByTagName("title").item(0)
                .getTextContent());
        // get company from xml
        NodeList elements =  el.getChildNodes();
        for (int i = 0 ; i < elements.getLength(); i++) {
            if (elements.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) elements.item(i);
                if (element.getNodeName().equals("company")) {
                    job.company = Company.getByXMLElement(element);
                }
            }
        }
        return job;
    }
}
