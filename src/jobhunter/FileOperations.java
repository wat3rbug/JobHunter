package jobhunter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import jobhunter.data.Company;
import jobhunter.data.Job;
import jobhunter.data.JobTitle;
import jobhunter.data.Location;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Douglas Gardiner
 */
public class FileOperations {

    public static ArrayList<Job> read() {
        return read("config.xml");
    }
    
    public static void write(ArrayList<Job> jobs) {
        write("config.xml", jobs);
    }
    
    public static void write(String filename, ArrayList<Job> jobs) {
        
        /**
         * I went the ghetto style because it is way too much work for
         * what it does.  I would need to define tags as Elements, document them
         * with Document Class and build the XML file with SAX Builder.  I may 
         * revisit it so it is extensible, but not at this moment.
         */
        
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File(filename));
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<Jobs>\n");
            for (int i = 0; i <jobs.size(); i++) {
                writer.write(jobs.get(i).toXML());
            }
            writer.write("</Jobs>\n</xml>");
        } catch (IOException ioe) {
            
        }  
    }
    
    public static ArrayList<Job> read(String filename) {
        ArrayList<Job> results = new ArrayList<Job>();
        File defaultFile = new File(filename);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {
            db = dbf.newDocumentBuilder();
            Document doc = db.parse(defaultFile);
            return getJobList(doc);
        } catch (Exception e) {
            return results;
        }
    }
    
    private static ArrayList<Job> getJobList(Document doc) {
        
        ArrayList<Job> jobList = new ArrayList<Job>();
        doc.getDocumentElement().normalize();
        Element docElement = doc.getDocumentElement();
        NodeList nList = doc.getElementsByTagName("Job");
        for (int i = 0; i < nList.getLength(); i++) {
            Node listItem = nList.item(i);
            Location loc = null;
            JobTitle title = null;
            Company company = null;
            Date jobDate = null;
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            boolean interview = false;
            if (listItem.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) listItem;
                loc = Location.getByXMLElement(elem);
                title = JobTitle.getByXMLElement(elem);
                company = Company.getByXMLElement(elem);
                interview = StringExtender.toBooleanValue(elem
                        .getElementsByTagName("interview").item(0)
                        .getTextContent());
                try {
                    jobDate = formatter.parse(elem.getElementsByTagName("date")
                        .item(0).getTextContent());
                } catch (ParseException pe) {
                    jobDate =  new Date();
                }              
            }
            Job job = new Job();
            job.company = company;
            job.loc = loc;
            job.title = title;
            job.hadInterview = interview;
            job.date = jobDate;
            jobList.add(job);
        }
        return jobList;
    }
}
