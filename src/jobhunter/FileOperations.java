package jobhunter;

import java.io.File;
import javax.xml.parsers.ParserConfigurationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import jobhunter.data.Company;
import jobhunter.data.Job;
import jobhunter.data.JobTitle;
import jobhunter.data.Language;
import jobhunter.data.Location;
import jobhunter.data.Recruiter;
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
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("Jobs");
            doc.appendChild(rootElement);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            for(Job job : jobs) {
                Element latestJob = doc.createElement("job");
                
                Element loc = doc.createElement("location");
                loc.appendChild(doc.createTextNode(job.loc.toString()));
                latestJob.appendChild(loc);
                
                Element title = doc.createElement("title");
                title.appendChild(doc.createTextNode(job.title.toString()));
                latestJob.appendChild(title);
                
                Element jobDate = doc.createElement("date");
                
                jobDate.appendChild(doc.createTextNode(formatter.format(job.date)));
                latestJob.appendChild(jobDate);
                
                Element hasInterview = doc.createElement("interview");
                hasInterview.appendChild(doc.createTextNode(StringExtender
                        .toYesNoString(job.hadInterview)));
                latestJob.appendChild(hasInterview);
                
                Element recruiterSite = doc.createElement("recruiter");
                recruiterSite.appendChild(doc.createTextNode(job.recruiter
                        .toString()));
                latestJob.appendChild(recruiterSite);
                
                Element langs = doc.createElement("languages");
                for (Language lang1 : job.langs) {
                    Element lang = doc.createElement("language");
                    lang.appendChild(doc.createTextNode(lang1.toString()));
                    langs.appendChild(lang);
                }
                latestJob.appendChild(langs);
                
                Element company = doc.createElement("company");
                Element companyName = doc.createElement("name");
                companyName.appendChild(doc.createTextNode(job.company.companyName));
                company.appendChild(companyName);
                
                Element companyStaff = doc.createElement("staffing");
                companyStaff.appendChild(doc.createTextNode(StringExtender
                        .toYesNoString(job.company.isStaffing)));
                company.appendChild(companyStaff);
                latestJob.appendChild(company);
                rootElement.appendChild(latestJob);
            }
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer tFormer = tFactory.newTransformer();
            DOMSource dSource = new DOMSource(doc);
            StreamResult sResult = new StreamResult(new File(filename));
            tFormer.transform(dSource, sResult);
        } catch(ParserConfigurationException saxpe) {
            // what to do if it fails?
            System.out.println("xml build failed");
        } catch (TransformerException te) {
            System.out.println("transform failed");
        }      
    }
    
    public static ArrayList<Job> read(String filename) {
        ArrayList<Job> results = new ArrayList<>();
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
        
        ArrayList<Job> jobList = new ArrayList<>();
        doc.getDocumentElement().normalize();
        Element docElement = doc.getDocumentElement();
        NodeList nList = doc.getElementsByTagName("job");
        for (int i = 0; i < nList.getLength(); i++) {
            Node listItem = nList.item(i);
            Location loc = null;
            JobTitle title = null;
            Company company = null;
            Date jobDate = null;
            Recruiter recruiter = null;
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            boolean interview = false;
            ArrayList<Language> langs = null;
            if (listItem.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) listItem;
                loc = Location.getByXMLElement(elem);
                title = JobTitle.getByXMLElement(elem);
                company = Company.getByXMLElement(elem);
                recruiter = Recruiter.getByXMLElement(elem);
                interview = StringExtender.toBooleanValue(elem
                        .getElementsByTagName("interview").item(0)
                        .getTextContent());
                langs = Language.getByXMLElement(elem);
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
            job.recruiter = recruiter;
            job.langs = langs;
            jobList.add(job);
        }
        return jobList;
    }
}
